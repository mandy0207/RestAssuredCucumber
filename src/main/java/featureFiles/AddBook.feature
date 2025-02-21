Feature: Verify Add Book

@Smoke
Scenario: verify user is able to add single Book
Given library api is available
When user sends post request to add book with unique creds
Then the status code should be "200"
And response should contain message "successfully added"


@Smoke
Scenario Outline: Verify Book Addition using Data Parameterisation
Given library api is available
When user sends post request to add book with "<bookName>" "<isbn>" "<aisle>" "<author>"
Then the status code should be "200"
And response should contain message "successfully added"
 Examples:
        |  bookName             |   isbn          |     aisle     | author     |
        |  Learn RestAssured    |   bhjvhvhj      |     kjnjk			|Sugesh 	   |
        |  Learn Appium         |   hchjvhc       |     jbjbjb    | Alby       |
        |  Learn Selenium       |   hhhihih       |     knnknn    | Nasreen    |
        
        
        

