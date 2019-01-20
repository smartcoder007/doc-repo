package awslambda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class ProcessSQSEvents implements RequestHandler<Object, Void>{
	static final Logger logger = LogManager.getLogger(ProcessSQSEvents.class);
    public Void handleRequest(Object event, Context context)
    {
    	if(event==null){
    		logger.info("No event receieved.................. " );
    		return null;
    	} else {
            logger.info("Received event: " + event.toString());
    	}
        
        return null;
    }
}