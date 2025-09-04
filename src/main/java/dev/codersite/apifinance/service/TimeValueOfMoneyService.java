package dev.codersite.apifinance.service;

import dev.codersite.apifinance.model.SimpleInterestResponse;

public interface TimeValueOfMoneyService {

  /**
   *
   * @param principal
   * @param interestRate
   * @param unitOfTime
   * @param time
   * @param yearDaysConvention
   * @return
   * @throws Exception
   */
  public SimpleInterestResponse getSimpleInterest(
      Integer principal,
      Integer interestRate,
      String unitOfTime,
      Integer time,
      String yearDaysConvention) throws Exception;
}
