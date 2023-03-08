var app = angular.module("EmployeeManagement", []);
 
// Controller Part
app.controller("EmployeeController", function($scope, $http) {
 
 
    $scope.employees = [];
    $scope.employee = {
        designation: '',
        dateOfJoining: '',
		retirementDate:'',
		basicPay:0.0,
		da:0.0,
		specialAllowance:0.0,
		professionalTax:0.0,
		pf:0.0
    };
 
    // Now load the data from server
    _refreshEmployeeData();
  
    $scope.submitEmployee = function() {
 
        var method = "";
        var url = "";
 
        if ($scope.employee.empId) {
            method = "PUT";
            url = '/employees/save';
        } else {
            method = "POST";
            url = '/employees/save';
        }
 
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.employee),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    $scope.createEmployee = function() {
        _clearFormData();
    }
 
    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}
    $scope.deleteEmployee = function(employee) {
        $http({
            method: 'DELETE',
            url: '/employees/delete/' + employee.empId
        }).then(_success, _error);
    };
 
    // In case of edit
    $scope.editEmployee = function(employee) {
	 	$scope.employee.empId = employee.empId;
        $scope.employee.designation = employee.designation;
        $scope.employee.dateOfJoining = new Date(employee.dateOfJoining);
		$scope.employee.retirementDate = new Date(employee.retirementDate);
        $scope.employee.basicPay = employee.basicPay;
		$scope.employee.da = employee.da;
        $scope.employee.specialAllowance = employee.specialAllowance;
		$scope.employee.professionalTax = employee.professionalTax;
        $scope.employee.pf = employee.pf;
    };
 
    // Private Method  
    // HTTP GET- get all employees collection
    // Call: http://localhost:8080/employees
    function _refreshEmployeeData() {
        $http({
            method: 'GET',
            url: '/employees'
        }).then(
            function(res) { // success
                $scope.employees = res.data._embedded.employees;
				console.log("respnse:" + res.data)
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
        _refreshEmployeeData();
        _clearFormData();
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    // Clear the form
    function _clearFormData() {
        $scope.employee.empId = -1;
        $scope.employee.designation = "";
        $scope.employee.dateOfJoining = ""
    };
});