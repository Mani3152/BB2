Feature: Download Asset Info

  Scenario Outline: Download Asset Info
    Given Go to particualr asset <name>
    When CLick on download button and select the format <type> <content>
    Then CHeck the downloaded file <Toaster>

    Examples:
      | name                 | type   | content                           | Toaster                                 |
      | "Skyview Apartments" | "Pdf"  | "Overview,Valuations,Loans,Units" | "Successfully Downloaded Asset Details" |
