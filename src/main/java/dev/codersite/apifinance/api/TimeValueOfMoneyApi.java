package dev.codersite.apifinance.api;

import dev.codersite.apifinance.model.SimpleInterestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Tags(value = {@Tag(name = "timeValueOfMoney")})
@RequestMapping("/v1/timeValueOfMoney")
public interface TimeValueOfMoneyApi {

  @Operation(
    summary = "Gets the calculated simple interest",
    description = "Gets the calculated simple interest for the requested parameters",
    tags={ "timeValueOfMoney" })
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
        schema = @Schema(implementation = SimpleInterestResponse.class)))
  })
  @RequestMapping(value = "/simpleInterest",
    produces = {"application/json"},
    method = RequestMethod.GET)
  ResponseEntity<SimpleInterestResponse> getSimpleInterest(
    @Parameter(in = ParameterIn.QUERY, description = "It is the principal amount", schema = @Schema())
    @Valid @RequestParam(value = "principal", required = true)
    Integer principal,
    @Parameter(in = ParameterIn.QUERY, description = "It is the annual rate of interest", schema = @Schema())
    @Valid @RequestParam(value = "interestRate", required = true)
    Integer interestRate,
    @Parameter(in = ParameterIn.QUERY, description = "Defines the Unit of Time.", schema=@Schema(allowableValues={ "DAYS", "YEARS" }, defaultValue="DAYS"))
    @Valid @Pattern(regexp="^(-|\\+)?(DAYS|YEARS)$", message="parameter 'unitOfTime' invalid, values allowed: DAYS|YEARS")
    @RequestParam(value = "unitOfTime", required = false)
    String unitOfTime,
    @Parameter(in = ParameterIn.QUERY, description = "It is the period of time for which the principal is invested", schema = @Schema())
    @Valid @RequestParam(value = "time", required = true)
    Integer time,
    @Parameter(in = ParameterIn.QUERY, description = "A days/year count convention. Available values : 360, 365", schema=@Schema(allowableValues={ "360", "365" }, defaultValue="360"))
    @Valid @Pattern(regexp="^(-|\\+)?(360|365)$", message="parameter 'yearDaysConvention' invalid, values allowed: 360|365")
    @RequestParam(value = "yearDaysConvention", required = false, defaultValue = "360")
    String yearDaysConvention
  ) throws Exception;

}
