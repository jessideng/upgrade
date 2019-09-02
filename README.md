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

  UI Test uses chromedriver installed in drivers directory. Additional driver can be supported if needed.
    1. Install selenium-standalone and start selenium server (not needed if selenium server is already installed)
       - npm install selenium-standalone -g
       - selenium-standalone install   
       - selenium-standalone start
    2. Download chromedriver to drivers directory
       - Download chromedriver that's compatible with chrome version install, https://chromedriver.chromium.org/downloads
       - create drivers directory in currect project directy (refer to project structure)
           - mkdir drivers
            - ls current project directory would yield
               - README.md	    drivers	     	pom.xml	  	  src
       - move chromedriver to drivers directory

- Tests can be run from both IDE and command line
  - To run from IDE, choose Run As TestNG test
  - From command line
    - Run UI Test
      - mvn clean test -Dsuite=offerTests
    - Run API test
      - mvn clean test -Dsuite=stateInfoTests
    - Run all tests
      - mvn clean test -Dsuite=allIntegrationTests

