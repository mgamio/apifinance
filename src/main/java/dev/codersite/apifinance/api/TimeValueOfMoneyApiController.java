package dev.codersite.apifinance.api;

import dev.codersite.apifinance.model.SimpleInterestResponse;
import dev.codersite.apifinance.service.TimeValueOfMoneyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeValueOfMoneyApiController implements TimeValueOfMoneyApi {

  private final TimeValueOfMoneyService timeValueOfMoneyService;

  public TimeValueOfMoneyApiController(
    TimeValueOfMoneyService timeValueOfMoneyService) {
    this.timeValueOfMoneyService = timeValueOfMoneyService;
  }

  @Override
  public ResponseEntity<SimpleInterestResponse> getSimpleInterest(
    Integer principal,
    Integer interestRate,
    String unitOfTime,
    Integer time,
    String yearDaysConvention) throws Exception {

    SimpleInterestResponse response  = timeValueOfMoneyService.getSimpleInterest(
        principal,
        interestRate,
        unitOfTime,
        time,
        yearDaysConvention);

    return new ResponseEntity<SimpleInterestResponse> (response, HttpStatus.OK);
  }
}
