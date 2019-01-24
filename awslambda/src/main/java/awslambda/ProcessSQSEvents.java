package awslambda;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.event.S3EventNotification.S3EventNotificationRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProcessSQSEvents implements RequestHandler<Object, String> {

	public String handleRequest(Object event, Context context) {
		LambdaLogger logger = context.getLogger();
		try {
			if (event == null) {
				logger.log("No event receieved.................. ");
				return "No data found";
			}  else if (event instanceof LinkedHashMap) {			
				uploadFileIntoS3(((LinkedHashMap) event),logger);
			} else {
				logger.log("Received event: " + event.getClass());
				logger.log("Received event: " + event.toString());
				return "success";
			}
		} catch (Exception e) {
			logger.log("Exception details : " + e.getMessage() );
			e.printStackTrace();
		}
		return "success";

	}

	public void uploadFileIntoS3(LinkedHashMap event,LambdaLogger logger) throws UnsupportedEncodingException, AmazonServiceException, SdkClientException, JsonProcessingException {
		final String TARGET_BUCKET = "sqsbucket1122/sqsmsg/";
		
		
		
		LinkedHashMap<String, Object> requestsLHM = (LinkedHashMap<String, Object>) event;
		if (requestsLHM != null) {
			ArrayList<LinkedHashMap<String, Object>> myRequests = (ArrayList<LinkedHashMap<String, Object>>) requestsLHM.get("Records");
			logger.log(myRequests.toString());
			if (myRequests != null) {
				// pick only the first record, might be a bunch!
				LinkedHashMap<String, Object> myRequest = myRequests.get(0);
			}

		} else {
			logger.log("Could not identify request object.\n");
		}

		// STEP1: Read input event and extract file details which got added to
		// the source bucket
		//S3EventNotificationRecord record = event.getRecords().get(0);
		S3EventNotificationRecord record = null;
		String srcBucket = record.getS3().getBucket().getName();
		// Remove any spaces or unicode non-ASCII characters.
		String srcKey = record.getS3().getObject().getKey().replace('+', ' ');
		srcKey=srcKey.split(".")[0];
		
		srcKey = URLDecoder.decode(srcKey, "UTF-8");		
		srcKey = srcKey.replace(" ", "");
		String dstKey = srcKey+".txt";
		logger.log("srcBucket=" + srcBucket + " srcKey=" + srcKey);
		logger.log("targetBucket=" + TARGET_BUCKET + " destKey=" + srcKey);

		// STEP2: Create S3 client
		AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
		
		// STEP3: Uploading to S3 target bucket
		s3Client.putObject(TARGET_BUCKET, dstKey, getJonsObject(event));
		logger.log("Successfully processed " + srcBucket + "/" + srcKey + " and uploaded to " + TARGET_BUCKET
				+ "/" + dstKey);

	}
	
	private String getJonsObject(S3Event event) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();		
		//Object to JSON in String
		String jsonInString = mapper.writeValueAsString(event);
		return jsonInString;

	}
	
	private String getJonsObject(LinkedHashMap event) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();		
		//Object to JSON in String
		String json = mapper.writeValueAsString(event);
		return json;

	}

}