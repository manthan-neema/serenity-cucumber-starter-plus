# Cucumber Tips:

- Give some time for writing cucumber scenarios and requirement discovery as they are the foundation for step
  definition.
- Write executable specifications for cucumber have a exact input and an exact output.
- DON'T use ui element interaction in cucumber like "click on button" as possible, instead create ui interaction
  classes.
- Use cucumber test cases only for features and not for test cases (script) like "click on button"
- Write cucumber test by thinking in terms of business requirements in the mind.
- USE DATA TABLE/Examples as per whichever is easy in reading, it is possible to use both as well,, but readability is
  at most.
- Always use IntellIJ with their useful plugins, eclipse is old class now.

# User Story Template:
Feature: [Feature Heading] <br>
    As a [type of user]  <br>
    I want [capability] <br>
    so that [business value] <br>

Background: [Feature Heading] <br>
Given a global administrator named "Greg"
And a blog named "Greg's anti-tax rants"
And a customer named "Dr. Bill"
And a blog named "Expensive Therapy" owned by "Dr. Bill"

Scenario: Dr. Bill posts to his own blog
Given I am logged in as Dr. Bill
When I try to post to "Expensive Therapy"
Then I should see "Your article was published."































