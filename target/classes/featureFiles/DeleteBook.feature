Feature: Verify Delete Book API


@Sanity
Scenario Outline: Verify user is able to delete book using ID
Given library baseURL is available
When user sends post request to add book with unique creds
Then user sends delete request to delete book using ID
Then the status code should be "200"







