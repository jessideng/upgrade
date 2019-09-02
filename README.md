- UI Test setup
  1. Install selenium-standalone driver
  2. Downloand chromedriver
  3. Start selenium server
  
- To run UI test
  - mvn clean test -Dsuite=offerTests


- To run API test
  - mvn clean test -Dsuite=stateInfoTests


- To run all tests
  - mvn clean test -Dsuite=allIntegrationTests
