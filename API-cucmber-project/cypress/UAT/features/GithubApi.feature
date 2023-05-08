Feature:  Api Testing for GitHub As a Project

    Scenario: Create a repository for the authenticated user
        Given Make a post request with the resource '/user/repos'
        Then Print the response in console
        Then Store Necessary data in the variable
        Then The response status code should be '201'
        And Check Wether the RepoName is stored in variable 'Team-StarCathcers-GithubAPI'
    
    Scenario: Update a Repository
        Given Make a patch request with resource '/repos/Tusharsangai/Team-StarCathcers-GithubAPI'
        When Print the response in console
        Then Store Necessary data in the variable
        And The response status code should be '200'
        Then Check the Updated RepoName 'Team-Milkeyway'
    
    Scenario: Get a Repository
    Given Make a GET request with resource '/repos/Tusharsangai/'
    When Print the response in console
    Then The response status code should be '200'
    
    Scenario: Create file contents
        Given Make a PUT request with the resource '/repos/Tusharsangai/Team-Milkeyway/contents/README.md'
        Then Print the response in console
        Then Store Necessary data in the variable
        Then The response status code should be '201'
        And Check Wether the sha value is stored in variable
    
   Scenario: CREATE A FORK
        Given Make a POST request with the resource '/repos/Tusharsangai/Team-Milkeyway/forks'
        Then Print the response in console
        And The response status code should be '202'
   
   
    Scenario: LIST FORKS
        Given Make a GET request For FORKS with the resource '/repos/Tusharsangai/Team-Milkeyway/forks'
        Then Print the response in console
        And The response status code should be '200'

    Scenario:  GET A LIST Of REPOSITORY
        Given Make a GET request For LIST OF REPOSITORY with the resource '/users/Tusharsangai/repos'
        Then Print the response in console
        And The response status code should be '200'   

    Scenario: List repository languages
        Given Make a GET request for repositories languages with the resource '/repos/Tusharsangai/Team-Milkeyway/languages'
        Then Print the response in console
        And The response status code should be '200'  

    Scenario: List public repositories
        Given Make a GET request for public repositories with the resource '/repositories'
        Then Print the response in console
        And The response status code should be '200'     
    
    Scenario: Delete a FORK
        Given Make a Delete request with the resource '/repos/Tushar-NewOrganization/New-Fork2'
        And The response status code should be '204'
    
    Scenario: Delete a file
        Given Make a Delete file request with the resource '/repos/Tusharsangai/Team-Milkeyway/contents/README.md'
        And The response status code should be '200'

    Scenario: Create a release
        Given Make a POST request to create a release with the resource '/repos/Tusharsangai/Team-Milkeyway/releases'
        Then Print the response in console
        And The response status code should be '201' 

     Scenario: List repository tags
        Given Make a GET request for repositories tags with the resource '/repos/Tusharsangai/Team-Milkeyway/tags'
        Then Print the response in console
        And The response status code should be '200'

    Scenario: Create an autolink reference for a repository
        Given Make a POST request For autolink with the resource '/repos/Tusharsangai/Team-Milkeyway/autolinks'
        Then Print the response in console
        Then Store Necessary data in the variable
        Then The response status code should be '201'          
    
    Scenario: Replace all repository topics
        Given Make a PUT request for repositories topics with the resource '/repos/Tusharsangai/Team-Milkeyway/topics'
        Then Print the response in console
        And The response status code should be '200'

    Scenario: Get all repository topics
        Given Make a GET request for repositories topics with the resource '/repos/Tusharsangai/Team-Milkeyway/topics'
        Then Print the response in console
        And The response status code should be '200'  

    Scenario: Get an autolink reference of a repository
        Given Make a GET request for repositories autolink with the resource '/repos/Tusharsangai/Team-Milkeyway/autolinks/'
        Then Print the response in console
        And The response status code should be '200'      
    
    Scenario: Delete an autolink reference from a repository
        Given Make a Delete request to delete autolink with the resource '/repos/Tusharsangai/Team-Milkeyway/autolinks/'
        Then The Delete response status code should be '204'
    
    Scenario: Get a repository
        Given Make a GET request  with the resource '/repos/Tusharsangai/Team-Milkeyway'
        Then Print the response in console
        And The response status code should be '200'

    Scenario: Delete a repository
        Given Make a Delete request with the resource '/repos/Tusharsangai/Team-StarCathcers-GithubAPI'
        Then The Delete response status code should be '204'