/**
 * Home controller
 */
function HomeInfoController($scope, homeinfoservice) {
	console.log("HomeInfoController");
	// Initialize variables
	$scope.homeDetails = [];
	$scope.home = {};
	$scope.homeUpdate = {};
	$scope.resTable=[];  
	$scope.UserGroup=[];
	$scope.residentsList=[];
	
	homeinfoservice.getHomeDetails(function(response) {
		console.log('controller res' + JSON.stringify(response))
		$scope.homeDetails = response.object;
	});
	
		   


		$scope.addNewHome = function() {
		console.log('addNewHome ' + JSON.stringify($scope.home));
		var newHome = angular.copy($scope.home);
		
		
		// Resident mapping
		if ($scope.selectedRsdts) {
			var obj2 = {};
			var objArray2 = [];
			$scope.residentsList.forEach(function(value, index) {				
				if (value.id === $scope.selectedRsdts) {
					obj2['residentId'] = value.id;
					obj2.residentName = '';
					angular.forEach(value.residentName, function(v, k) {
						if (v) {
							obj2.residentName += (v + ' ');
						}
					});
					objArray2.push(obj2);
					obj2 = {};
					console.log("obj2 ", obj2);
				}
				console.log('objArray2 ' + JSON.stringify(objArray2))				
				if(typeof $scope.home.residentList !== 'undefined'){					
					$scope.home['residentList'] = objArray2;					
				} else{
					console.log('residentList undefined ');
					$scope.home.residentList =objArray2;
				}
				
			});
		}
		
		//  Home assisted mapping
		var obj = {};
		var objArray = [];
		var alertArray = [];
		if ($scope.homeagents) {
			$scope.homeagents.forEach(function(value, index) {
				if (value.name === null) {
					obj.id = value.userGroupId;
					obj.name = value.userGroupName;
				} else {
					obj.id = value.userGroupId;
					obj.name = value.name.firstName;
				}

				objArray.push(obj);
				obj = {};
			});
			newHome['caregivers'] = objArray;
		}
		console.log('constrcuted req ' + JSON.stringify(newHome));

		homeinfoservice.savehomeList(newHome, function(response) {
			console.log('HomeInfoController->homeinfoservice.savehomeList' + JSON.stringify(response));
			if (response.status === 'success') {
				newHome = angular.copy(response.object);
				$scope.homesTable.push(newHome);
				$scope.homesTable = $filter('orderBy')($scope.homesTable,
						$scope.propertyName, $scope.reverse);
				allHomes.push($scope.home);
				$scope.msg = "Successfully created.";
				angular.element('#homeSuccessModel').modal('show');
			} else {
				$scope.msg = "Unable to create Home.";
				// angular.element('#homeErrorModel').modal('show');
			}

		});
	};
	
	

		$scope.updateHome = function() {
		console.log('updateHome ' + JSON.stringify($scope.homeUpdate));
		

		homeinfoservice.updateHome($scope.homeUpdate, function(response) {
			console.log('updateHome ' + JSON.stringify($scope.homeUpdate));
			if (response.status === 'success') {
				console.log("edit successful "
						+ JSON.stringify(response.object));
				$scope.msg = "Successfully updated.";
				angular.element('#homeSuccessModel').modal('show');

			} else {

				$scope.msg = "Unable to update Home details.";
				angular.element('#homeErrorModel').modal('show');

			}

		});

	};
	
	$scope.deleteHome = function() {
		var query = 'query=id:H001';       
		console.log(query);
		homeinfoservice.deleteHome({query : query }, function(response) {
			if (response.status === "success") {
				console.log('success');
			}
			else{				
				console.log('error');
			}
            
		});
        
	};

	// Hard code json data
	$scope.resTable=[{"id":"R003","residentName":{"firstName":"Rebecca3","middleName":"","lastName":"Lim"},"agentId":"A003","personId":"P003","activeState":"true","gender":"male","dob":"03/01/2017","address":null,"email":null,"contactNo":["232323","44343"],"emergencyContactPersonId":null,"alertRuleList":null,"photo":"","remarks":"Remarks for Resident2...sdfasdf","createdBy":"U001","createdOn":"01/07/2016 10:05:43","updatedBy":"U002","updatedOn":"01/07/2016 10:05:43","caregivers":null},{"id":"R004","residentName":{"firstName":"Ah123","middleName":"wa123","lastName":"Peng123"},"agentId":"5874831860b25e830d2b20e3","personId":"5874831860b25e830d2b20e4","activeState":null,"gender":"female","dob":"22/08/1970","address":null,"email":"ah123@smu.edu","contactNo":["1","2","3"],"emergencyContactPersonId":null,"alertRuleList":null,"photo":null,"remarks":"rem1...and tested....","createdBy":"U001","createdOn":"2017-01-10T06:45:06.488Z","updatedBy":null,"updatedOn":null,"caregivers":null},{"id":"R007","residentName":{"firstName":"Raj","middleName":null,"lastName":"Shah"},"agentId":"5878dc6060b22e049dc504cb","personId":"5878dc6060b22e049dc504cc","activeState":null,"gender":"male","dob":"11/01/2017","address":null,"email":"","contactNo":["1234"],"emergencyContactPersonId":null,"alertRuleList":null,"photo":null,"remarks":null,"createdBy":"U001","createdOn":"2017-01-13T13:55:29.494Z","updatedBy":null,"updatedOn":null,"caregivers":null},{"id":"R008","residentName":{"firstName":"Sara","middleName":null,"lastName":null},"agentId":"587dc28f60b2814924feee6a","personId":"587dc28f60b2814924feee6b","activeState":null,"gender":null,"dob":null,"address":null,"email":"","contactNo":["1234,3456"],"emergencyContactPersonId":null,"alertRuleList":null,"photo":null,"remarks":null,"createdBy":"U001","createdOn":"2017-01-17T07:06:34.914Z","updatedBy":null,"updatedOn":null,"caregivers":null},{"id":"R001","residentName":{"firstName":"Rebeca123","middleName":"t23","lastName":"Lims23"},"agentId":"A001","personId":"P001","activeState":"true","gender":"male","dob":"22/10/1992","address":null,"email":"rebecaa123@smu.edu","contactNo":["111","2233366","444223","55555"],"emergencyContactPersonId":null,"alertRuleList":null,"photo":"","remarks":"Remarks for Resident22233333asdfasfas.yesy yes......","createdBy":"U001","createdOn":"01/07/2016 10:05:43","updatedBy":"U002","updatedOn":"01/07/2016 10:05:43","caregivers":null},{"id":"R005","residentName":{"firstName":"testing","middleName":null,"lastName":null},"agentId":"5877448560b216105e4ed824","personId":"5877448560b216105e4ed825","activeState":null,"gender":"male","dob":"02/01/2017","address":null,"email":"","contactNo":["222222"],"emergencyContactPersonId":null,"alertRuleList":null,"photo":null,"remarks":null,"createdBy":"U001","createdOn":"2017-01-12T08:55:17.808Z","updatedBy":null,"updatedOn":null,"caregivers":null},{"id":"R002","residentName":{"firstName":"Rebecca2","middleName":"grg","lastName":"Limggg"},"agentId":"A002","personId":"P002","activeState":"true","gender":"female","dob":"12/01/2017","address":null,"email":"sghhs@yhdj","contactNo":["124","555","555555555"],"emergencyContactPersonId":null,"alertRuleList":null,"photo":"","remarks":"Remarks for Resident2...gbgasfasf","createdBy":"U001","createdOn":"01/07/2016 10:05:43","updatedBy":"U002","updatedOn":"01/07/2016 10:05:43","caregivers":null},{"id":"R006","residentName":{"firstName":"ttt","middleName":null,"lastName":null},"agentId":"5878a09960b2909f77e7215e","personId":"5878a09960b2909f77e7215f","activeState":null,"gender":null,"dob":"03/01/2017","address":null,"email":"","contactNo":[""],"emergencyContactPersonId":null,"alertRuleList":null,"photo":null,"remarks":null,"createdBy":"U001","createdOn":"2017-01-13T09:40:17.707Z","updatedBy":null,"updatedOn":null,"caregivers":null}];
	$scope.UserGroup=[{"userGroupId":"U004","userGroupName":"neha@smu.edu","entityType":"User","contact":null,"permissions":[{"permissionId":"P001","permissionName":"CAN_LOGIN"},{"permissionId":"P002","permissionName":"CAN_ACCESS_ASSIGNEDHOMES"},{"permissionId":"P006","permissionName":"CAN_ACCESS_ASSIGNEDRESIDENTS"},{"permissionId":"P012","permissionName":"CAN_ACCESS_ASSIGNEDHOMESREPORTS"},{"permissionId":"P014","permissionName":"CAN_ACCESS_ASSIGNEDALERTS"},{"permissionId":"P016","permissionName":"CAN_EDIT_ALERTS"},{"permissionId":"P017","permissionName":"CAN_REJECT_ALERTS"}],"name":{"firstName":"Neha","middleName":null,"lastName":null}},{"userGroupId":"U005","userGroupName":"mahesh@smu.edu","entityType":"User","contact":null,"permissions":[{"permissionId":"P001","permissionName":"CAN_LOGIN"},{"permissionId":"P002","permissionName":"CAN_ACCESS_ASSIGNEDHOMES"},{"permissionId":"P006","permissionName":"CAN_ACCESS_ASSIGNEDRESIDENTS"},{"permissionId":"P012","permissionName":"CAN_ACCESS_ASSIGNEDHOMESREPORTS"},{"permissionId":"P014","permissionName":"CAN_ACCESS_ASSIGNEDALERTS"},{"permissionId":"P016","permissionName":"CAN_EDIT_ALERTS"},{"permissionId":"P017","permissionName":"CAN_REJECT_ALERTS"}],"name":{"firstName":"Mahesh","middleName":null,"lastName":null}},{"userGroupId":"U006","userGroupName":"kiran@smu.edu","entityType":"User","contact":null,"permissions":[{"permissionId":"P001","permissionName":"CAN_LOGIN"},{"permissionId":"P002","permissionName":"CAN_ACCESS_ASSIGNEDHOMES"},{"permissionId":"P006","permissionName":"CAN_ACCESS_ASSIGNEDRESIDENTS"},{"permissionId":"P012","permissionName":"CAN_ACCESS_ASSIGNEDHOMESREPORTS"},{"permissionId":"P014","permissionName":"CAN_ACCESS_ASSIGNEDALERTS"},{"permissionId":"P016","permissionName":"CAN_EDIT_ALERTS"},{"permissionId":"P017","permissionName":"CAN_REJECT_ALERTS"}],"name":{"firstName":"Kiran","middleName":null,"lastName":null}},{"userGroupId":"U007","userGroupName":"deva@smu.edu","entityType":"User","contact":null,"permissions":[{"permissionId":"P001","permissionName":"CAN_LOGIN"},{"permissionId":"P002","permissionName":"CAN_ACCESS_ASSIGNEDHOMES"},{"permissionId":"P006","permissionName":"CAN_ACCESS_ASSIGNEDRESIDENTS"},{"permissionId":"P012","permissionName":"CAN_ACCESS_ASSIGNEDHOMESREPORTS"},{"permissionId":"P014","permissionName":"CAN_ACCESS_ASSIGNEDALERTS"},{"permissionId":"P016","permissionName":"CAN_EDIT_ALERTS"},{"permissionId":"P017","permissionName":"CAN_REJECT_ALERTS"}],"name":{"firstName":"Deva","middleName":null,"lastName":null}},{"userGroupId":"G002","userGroupName":"Care Givers","entityType":"Group","contact":null,"permissions":[],"name":null},{"userGroupId":"G001","userGroupName":"Administrators","entityType":"Group","contact":null,"permissions":[],"name":null}];
	//$scope.residentsList=["R001","R002","R003","R004","R005","R006","R007","R008"];
	$scope.residentsList=[{"id":"R003","residentName":{"firstName":"Rebecca3","middleName":"","lastName":"Lim"},"agentId":"A003","personId":"P003","activeState":"true","gender":"male","dob":"03/01/2017","address":null,"email":null,"contactNo":["232323","44343"],"emergencyContactPersonId":null,"alertRuleList":null,"photo":"","remarks":"Remarks for Resident2...sdfasdf","createdBy":"U001","createdOn":"01/07/2016 10:05:43","updatedBy":"U002","updatedOn":"01/07/2016 10:05:43","caregivers":null},{"id":"R004","residentName":{"firstName":"Ah123","middleName":"wa123","lastName":"Peng123"},"agentId":"5874831860b25e830d2b20e3","personId":"5874831860b25e830d2b20e4","activeState":null,"gender":"female","dob":"22/08/1970","address":null,"email":"ah123@smu.edu","contactNo":["1","2","3"],"emergencyContactPersonId":null,"alertRuleList":null,"photo":null,"remarks":"rem1...and tested....","createdBy":"U001","createdOn":"2017-01-10T06:45:06.488Z","updatedBy":null,"updatedOn":null,"caregivers":null},{"id":"R007","residentName":{"firstName":"Raj","middleName":null,"lastName":"Shah"},"agentId":"5878dc6060b22e049dc504cb","personId":"5878dc6060b22e049dc504cc","activeState":null,"gender":"male","dob":"11/01/2017","address":null,"email":"","contactNo":["1234"],"emergencyContactPersonId":null,"alertRuleList":null,"photo":null,"remarks":null,"createdBy":"U001","createdOn":"2017-01-13T13:55:29.494Z","updatedBy":null,"updatedOn":null,"caregivers":null},{"id":"R008","residentName":{"firstName":"Sara","middleName":null,"lastName":null},"agentId":"587dc28f60b2814924feee6a","personId":"587dc28f60b2814924feee6b","activeState":null,"gender":null,"dob":null,"address":null,"email":"","contactNo":["1234,3456"],"emergencyContactPersonId":null,"alertRuleList":null,"photo":null,"remarks":null,"createdBy":"U001","createdOn":"2017-01-17T07:06:34.914Z","updatedBy":null,"updatedOn":null,"caregivers":null},{"id":"R001","residentName":{"firstName":"Rebeca123","middleName":"t23","lastName":"Lims23"},"agentId":"A001","personId":"P001","activeState":"true","gender":"male","dob":"22/10/1992","address":null,"email":"rebecaa123@smu.edu","contactNo":["111","2233366","444223","55555"],"emergencyContactPersonId":null,"alertRuleList":null,"photo":"","remarks":"Remarks for Resident22233333asdfasfas.yesy yes......","createdBy":"U001","createdOn":"01/07/2016 10:05:43","updatedBy":"U002","updatedOn":"01/07/2016 10:05:43","caregivers":null},{"id":"R005","residentName":{"firstName":"testing","middleName":null,"lastName":null},"agentId":"5877448560b216105e4ed824","personId":"5877448560b216105e4ed825","activeState":null,"gender":"male","dob":"02/01/2017","address":null,"email":"","contactNo":["222222"],"emergencyContactPersonId":null,"alertRuleList":null,"photo":null,"remarks":null,"createdBy":"U001","createdOn":"2017-01-12T08:55:17.808Z","updatedBy":null,"updatedOn":null,"caregivers":null},{"id":"R002","residentName":{"firstName":"Rebecca2","middleName":"grg","lastName":"Limggg"},"agentId":"A002","personId":"P002","activeState":"true","gender":"female","dob":"12/01/2017","address":null,"email":"sghhs@yhdj","contactNo":["124","555","555555555"],"emergencyContactPersonId":null,"alertRuleList":null,"photo":"","remarks":"Remarks for Resident2...gbgasfasf","createdBy":"U001","createdOn":"01/07/2016 10:05:43","updatedBy":"U002","updatedOn":"01/07/2016 10:05:43","caregivers":null},{"id":"R006","residentName":{"firstName":"ttt","middleName":null,"lastName":null},"agentId":"5878a09960b2909f77e7215e","personId":"5878a09960b2909f77e7215f","activeState":null,"gender":null,"dob":"03/01/2017","address":null,"email":"","contactNo":[""],"emergencyContactPersonId":null,"alertRuleList":null,"photo":null,"remarks":null,"createdBy":"U001","createdOn":"2017-01-13T09:40:17.707Z","updatedBy":null,"updatedOn":null,"caregivers":null}];
}

angular.module('homeCareApp').controller('HomeInfoCtrl', [ '$scope', 'homeinfoservice', HomeInfoController ]);