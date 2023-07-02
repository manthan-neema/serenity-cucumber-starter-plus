Feature: Search by word

  @search
  Scenario: Searching for a word
    Given I navigate to google homepage
    When I search for "Chat GPT"
    Then I should see Chat GPT url in result