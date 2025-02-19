Feature: Verify User Login Test Cases

@Smoke
Scenario: verify user login with correct creds
Given library api is available
When user sends post request to add book with unique creds
Then the status code  should be "200"
And response should contain message "successfully added"

@Reg
Scenario Outline: Verify Book Addition using Data Parameterisation
Given library api is available
When user sends post request to add book with "<bookName>" "<isbn>" "<aisle>" "<author>"
Then the status code  should be "200"
And response should contain message "successfully added"
 Examples:
        |  bookName             |   isbn          |     aisle     | author     |
        |  Learn RestAssured    |   bhjvhvhj      |     kjnjk			|Sugesh 	   |
        |  Learn Appium         |   hchjvhc       |     jbjbjb    | Alby       |
        |  Learn Selenium       |   hhhihih       |     knnknn    | Nasreen    |
        
        
        

