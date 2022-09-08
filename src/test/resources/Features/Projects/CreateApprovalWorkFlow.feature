Feature: Create Approval Work Flow

  @Project_PreRequisite_2 @AWF1_GuideWellGroupInc
    Scenario: AWF1_GuideWellGroupInc
    Given login as admin
    Then Use excelsheet "Pre_Requisite.xlsx" and sheet "Approval_Workflow"
    Then Navigate to client detail page
    And Navigate to approval setup page
    Then Create new approval workflow
    And Insert Steps into new approval workflow

  @Project_PreRequisite_2 @AWF2_GuideWellGroupInc
  Scenario: AWF2_GuideWellGroupInc
    Given login as admin
    Then Use excelsheet "Pre_Requisite.xlsx" and sheet "Approval_Workflow"
    Then Navigate to client detail page
    And Navigate to approval setup page
    Then Create new approval workflow
    And Insert Steps into new approval workflow

  @Project_PreRequisite_2 @AWF3_GuideWellGroupInc
  Scenario: AWF3_GuideWellGroupInc
    Given login as admin
    Then Use excelsheet "Pre_Requisite.xlsx" and sheet "Approval_Workflow"
    Then Navigate to client detail page
    And Navigate to approval setup page
    Then Create new approval workflow for amend type
    And Insert Steps into new approval workflow

  @Project_PreRequisite_2 @AWF4_GuideWellGroupInc
  Scenario: AWF4_GuideWellGroupInc
    Given login as admin
    Then Use excelsheet "Pre_Requisite.xlsx" and sheet "Approval_Workflow"
    Then Navigate to client detail page
    And Navigate to approval setup page
    Then Create new approval workflow for amend type
    And Insert Steps into new approval workflow