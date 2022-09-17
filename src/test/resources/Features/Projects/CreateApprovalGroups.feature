@Project_PreRequisite @Regression
Feature: Create Approval Group

  @ApprovalGroup @Project_PreRequisite_1 @AddApprovalGroup1_GuideWellGroupInc
  Scenario: AddApprovalGroup1_GuideWellGroupInc
    Given login as admin
    Then Use excelsheet "Pre_Requisite.xlsx" and sheet "Project"
    Then Navigate to client detail page
    And Navigate to approval group page
    When Add new approval group
    Then Verify new approval group added successfully
    And Add approval manager in to approval group
    Then Verify approval manager added successfully

  @ApprovalGroup @Project_PreRequisite_1 @AddApprovalGroupPO_GuideWellGroupInc
  Scenario: AddApprovalGroupPO_GuideWellGroupInc
    Given login as admin
    Then Use excelsheet "Pre_Requisite.xlsx" and sheet "Project"
    Then Navigate to client detail page
    And Navigate to approval group page
    When Add new approval group
    Then Verify new approval group added successfully
    And Add approval manager in to approval group
    Then Verify approval manager added successfully

  @ApprovalGroup @Project_PreRequisite_1 @AddApprovalGroupPO_SEIT0019
  Scenario: AddApprovalGroupPO_SEIT0019
    Given login as admin
    Then Use excelsheet "Pre_Requisite.xlsx" and sheet "Project"
    Then Navigate to client detail page
    And Navigate to approval group page
    When Add new approval group
    Then Verify new approval group added successfully
    And Add approval manager in to approval group
    Then Verify approval manager added successfully

  @ApprovalGroup @Project_PreRequisite_1 @AddAutomationGroup_WyndhamWorldwide
  Scenario: AddAutomationGroup_WyndhamWorldwide
    Given login as admin
    Then Use excelsheet "Pre_Requisite.xlsx" and sheet "Project"
    Then Navigate to client detail page
    And Navigate to approval group page
    When Add new approval group
    Then Verify new approval group added successfully
    And Add approval manager in to approval group
    Then Verify approval manager added successfully