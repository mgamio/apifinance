package dev.codersite.apifinance.service;

import dev.codersite.apifinance.model.SimpleInterestResponse;

public class TimeValueOfMoneyServiceImpl implements TimeValueOfMoneyService {
  @Override
  public SimpleInterestResponse getSimpleInterest(
      Integer principal,
      Integer interestRate,
      String unitOfTime,
      Integer time,
      String yearDaysConvention) throws Exception {

    SimpleInterestResponse response = new SimpleInterestResponse();

    // Implement here ...

    return response;
  }
}
