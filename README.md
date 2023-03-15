# Settlement system

## Description

The app can save, delete, update, read. Three different objects, like Employee, Salary, and Settlement.
The general porpuse is to allow the employeer to employee's settlement when the contract is over, based in the reason, salary, etc.
The app will generate a settlement for each case. 


# Run the app 

## Run docker Compose file that is located in Deployment folder. 
Postgres(Port:5432) and PGAdmin(Port:5050)

## SpringBoot App 
The image is set up in Docker File and it will be running on port:8080


# Objects structure

## Employee 

{
    "id": "234567897",
    "name": "Santiago",
    "salary": "5000000",
    "startDate": "2020/12/24",
    "position": "DeveloperJunior",
    "employeeStatus": "ACTIVE"
}

## Salary

{
    "modificationDate": "2022/12/24",
    "newSalary": 7000000,
    "employeeIdSalary": "234567897"
}

## Settlement

{
    "employeeId":"234567897",
    "completionContractDate":"2023/05/05",
    "retirementReason": "justified"
}



