##Atlassian QA Questions

#### List of the Test Cases

1. The First Automated Test Case determines if the user can create a new page
2. The Second Automated Test Case determines if the user can put restrictions on the existing wiki page


####Prerequisites

1. An account on Confluence
2. A Test Space on the Confluence Cloud
3. The user should have Administrator / Author rights on the Test Space
4. For Testing the restriction work-flow , a test page should be present under the space
5. The Selenium Jars should be bundled with the Project , in the build path
6. The J-Unit Jars should be bundled with the project , in the build path

####Assumptions

1. The Dialogs should be opened within 15 seconds, since we have set the explicit timeout to be 15 seconds
2. The Page opened should be rendered within 15 seconds , since we have set the explicit timeout to be 15 seconds
3. The options , menus and the pages should be opened using a single click , logic for trying opening the page with the multiple attempts is not written
4. Assumptions for the Checking the *Restriction Workflow*:---- If the user is able to open the Restriction dialog , the user would be able to change the Restrictions around the page

####Steps for Running the TestCases in Eclipse

The TestRunner.java is the main driving class for the test cases to run, Please make sure that you have included all the test cases under the TestConfluencePageWorkflows in the run configurations.

####Contributors

1. Tushar Sappal (sappal.tushar@gmail.com)
