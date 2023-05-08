Feature:  Api Testing for GitHub As a Project

    Scenario: Create a repository for the authenticated user
        Given Make a post request with the resource '/user/repos'
        Then Print the response in console
        Then Store Necessary data in the variable
        Then The response status code should be 201
        And Check Wether the RepoName is stored in variable1 'Team-star-catcherapirepo'
    
    Scenario: Update a Repository
        Given Make a patch request with resource1 '/repos/Tusharsangai/Team-star-catcherapirepo'
        When Print the response in console of update
        Then Store Necessary data in the variable1 
        And The Response status code should1 be 200
        Then Check the Updated RepoName1 'Team-Milkeyway'
    
    Scenario: Get a Repository
    Given Make a GET request with resource2 '/repos/Tusharsangai/'
    When Print the response in console2
    Then The response status code should2 be 200
    
    Scenario: Create file contents
        Given Make a PUT request with the resource3 '/repos/Tusharsangai/Team-Milkeyway/contents/README.md'
        Then Print the response in console3
        Then Store Necessary data in the variable3
        Then The response status code should3 be 201
        And Check Wether the sha value is stored in variable2
    
   Scenario: CREATE A FORK
        Given Make a POST request with the resource4 '/repos/Tusharsangai/Team-Milkeyway/forks'
        Then Print the response in console4
        And The response status code should4 be 202
   
   
    Scenario: LIST FORKS
        Given Make a GET request For FORKS with the resource5 '/repos/Tusharsangai/Team-Milkeyway/forks'
        Then Print the response in console5
        And The response status code should5 be 200

    Scenario:  GET A LIST Of REPOSITORY
        Given Make a GET request For LIST OF REPOSITORY with the resource6 '/users/Tusharsangai/repos'
        Then Print the response in console6
        And The response status code should6 be 200  

    Scenario: List repository languages
        Given Make a GET request for repositories languages with the resource7 '/repos/Tusharsangai/Team-Milkeyway/languages'
        Then Print the response in console7
        And The response status code should7 be 200  

    Scenario: List public repositories
        Given Make a GET request for public repositories with the resource8 '/repositories'
        Then Print the response in console8
        And The response status code should8 be 200     
    
    Scenario: Delete a FORK
        Given Make a Delete request with the resource9 '/repos/Tushar-NewOrganization/New-Fork2'
        And The response status code should9 be 204
    
    Scenario: Delete a file
        Given Make a Delete file request with the resource10 '/repos/Tusharsangai/Team-Milkeyway/contents/README.md'
        And The response status code should10 be 200

    Scenario: Create a release
        Given Make a POST request to create a release with the resource11 '/repos/Tusharsangai/Team-Milkeyway/releases'
        Then Print the response in console11
        And The response status code should11 be 201 

     Scenario: List repository tags
        Given Make a GET request for repositories tags with the resource12 '/repos/Tusharsangai/Team-Milkeyway/tags'
        Then Print the response in console12
        And The response status code should12 be 200

    Scenario: Create an autolink reference for a repository
        Given Make a POST request For autolink with the resource13 '/repos/Tusharsangai/Team-Milkeyway/autolinks'
        Then Print the response in console13
        Then Store Necessary data in the variable5
        Then The response status code should13 be 201          
    
    Scenario: Replace all repository topics
        Given Make a PUT request for repositories topics with the resource14 '/repos/Tusharsangai/Team-Milkeyway/topics'
        Then Print the response in console14
        And The response status code should14 be 200

    Scenario: Get all repository topics
        Given Make a GET request for repositories topics with the resource15 '/repos/Tusharsangai/Team-Milkeyway/topics'
        Then Print the response in console15
        And The response status code should15 be 200  

    Scenario: Get an autolink reference of a repository
        Given Make a GET request for repositories autolink with the resource16 '/repos/Tusharsangai/Team-Milkeyway/autolinks/'
        Then Print the response in console16
        And The response status code should16 be 200      
    
    Scenario: Delete an autolink reference from a repository
        Given Make a Delete request to delete autolink with the resource17 '/repos/Tusharsangai/Team-Milkeyway/autolinks/'
        Then The Delete response status code should17 be 204
    
    Scenario: Get a repository
        Given Make a GET request  with the resource18 '/repos/Tusharsangai/Team-Milkeyway'
        Then Print the response in console18
        And The response status code should18 be 200

    Scenario: Delete a repository
        Given Make a Delete request with the resource20 '/repos/Tusharsangai/Team-Milkeyway'
        Then The Delete response status code should20 be 204