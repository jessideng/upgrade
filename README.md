- Project Structure
  -  pom.xml
       - main
          - java
            - common
            - config
            - data
            - pages
            - util
          - resources
            - config.properties
       - test
          - java
             - UI test
               - LoanApplicationTest.java
             - API test
               - StateInfoValidationTest.java
          - resources
            - testng.xml
   - drivers
        - chromedriver
        
- UI Test setup

UI Test uses chromedriver installed in drivers directory. Additional driver can be suppored if needed.
  1. Install selenium-standalone driver 
      - npm install selenium-standalone -g
      - selenium-standalone install   
  2. Download chromedriver to drivers directory
      - Download chromedriver that's compatible with chrome version install, https://chromedriver.chromium.org/downloads
      - create drivers directory in currect project directy (refer to project structure)
          - mkdir drivers
          - ls current project directory would yield
              - README.md	drivers		pom.xml		src
      - move chromedriver to drivers directory
  3. Start selenium server
      - selenium-standalone start

- Tests can be run from both IDE and command line
  - To run from IDE, choose Run As TestNG test
  - From command line
    - Run UI Test
      - mvn clean test -Dsuite=offerTests
    - Run API test
      - mvn clean test -Dsuite=stateInfoTests
    - Run all tests
      - mvn clean test -Dsuite=allIntegrationTests

