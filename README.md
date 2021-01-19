# business-validation-common

Define base interface and common logic for API business validation


## Summary

In microservice API, normally it has validation in two levels:

- Openapi schema validation

  Field level validation for request/response in the openapi specification.
  
  For example: required fields, data type, data format...
  
- Business validation
  
  Certain business rule validation for which cannot be defined the detail in the openapi specification
  
  For example, validate account number for different account type; validate driving license number issued from different country/place




For business validation,  developers more like to build the business validation in pure java code.

Ideally, we would like to build the complex business validation to small and light validation validators as validation chain.
The validator chain can be plugin to the service class to controller/handler which will not impact the business logic implmentation in the service/controller/handler classes.
  

## Implementation detail:

For validator implementation, please refer the example in the /sample package



To invoke the validator class list stream

- Initial validators (get the list validators which implements BaseValidator interface )

For example, on Sprint-boot:

```
  @Autowired
  List<BaseValidator> validators;

```

- Invoke the validators

```
        List<ValidationCode> codes = new ArrayList<>();
        Stream<ValidationResult> validationResultStream = validators.stream().filter(validator->validator.support(FILTER_NAME)).flatMap(v->v.validate(null,drivingLicense));
        validationResultStream.filter(v->v.isError()).forEach(v->codes.addAll(v.getValidationCodes()));
        if (codes.size()>0) {
            //TODO throw exception or return error codes
        }

```


 