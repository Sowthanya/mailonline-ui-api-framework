@PetStore
Feature: Pet Store Validation

 @AddPet
 Scenario Outline: Add a new Pet
 When I add a new pet to the store with the "<EndPoint>"
 Then I verify the response code as <ResponseCode>
 Examples:    
    | EndPoint |ResponseCode|
    | pet      |200				  |
    
@AddPetInvalidEndpoint
 Scenario Outline: Try to Add a new Pet with invalid payload
 When I add a new pet to the store with the "<EndPoint>" with invalid id
 Then I verify the response code as <ResponseCode>
 Examples:    
    | EndPoint |ResponseCode|
    | pet      |500				  |
    
 @GetPetDetails
 Scenario Outline: Get the pet details
 When I get the details of the pet <PetId> , "<EndPoint>"
 Then I verify the response code as <ResponseCode>
 Examples:    
    | EndPoint |ResponseCode|PetId|
    | pet      |200				  |59		|
    
@GetInvalidPetDetails
 Scenario Outline: Get the invalid pet details
 When I get the details of the pet <PetId> , "<EndPoint>"
 Then I verify the response code as <ResponseCode>
 And I verify the response message as "<Message>"
 Examples:    
    | EndPoint |ResponseCode|PetId|Message			|
    | pet      |404				  |0		|Pet not found|