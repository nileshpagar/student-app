Feature: end to end student integration test
  Scenario: automate end to end integration of student app
    When The student is registered in class '1A'
    Then Query student registered
    And Update student class name
    And Query student registered
    And delete the student