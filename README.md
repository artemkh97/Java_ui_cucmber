# Demo UI example 

(Cucumber JVM6 + JUnit5 + Selenide + Gradle + Allure)
https://www.demoblaze.com/index.html

## Run tests

* run all tests in parallel (with different number of threads)

  ```
  $ gradle -Dthreads=2 clean cucumber
  ```

* run all tests with specific tag

  ```
  $ gradle -DcucumberTags=@addProductExample clean cucumber
  ```
    ```
  $ gradle -DcucumberTags=@add-to-cart clean cucumber
  ```


## Allure reports

* Allure should be installed (download Allure)
* Allure results saved in `build/allure-results`
* To generate allure report
  ```
  $ gradle allureServe
  ```

## Cucumber configuration

* Glue or steps classes `io.demoblaze.steps`
* Feature files `src.resources.features`
