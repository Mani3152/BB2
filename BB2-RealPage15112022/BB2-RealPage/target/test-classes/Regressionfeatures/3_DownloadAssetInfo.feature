Feature: Download Asset Info

  Scenario Outline: Download Asset Info
    Given Go to particualr asset <name>
    When CLick on download button and select the format <type> <content>
    Then CHeck the downloaded file <Toaster>

    Examples:
      | name                 | type   | content                           | Toaster                                 |
      | "Skyview Apartments" | "Pdf"  | "Overview,Valuations,Loans,Units" | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Doc"  | "Overview,Valuations,Loans,Units" | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Xlsx" | "Overview,Valuations,Loans,Units" | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Pdf"  | "Overview,Valuations,Loans"       | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Doc"  | "Overview,Valuations,Loans"       | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Xlsx" | "Overview,Valuations,Loans"       | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Pdf"  | "Overview,Valuations,Units"       | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Doc"  | "Overview,Valuations,Units"       | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Xlsx" | "Overview,Valuations,Units"       | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Pdf"  | "Overview,Loans,Units"            | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Doc"  | "Overview,Loans,Units"            | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Xlsx" | "Overview,Loans,Units"            | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Pdf"  | "Valuations,Loans,Units"          | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Doc"  | "Valuations,Loans,Units"          | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Xlsx" | "Valuations,Loans,Units"          | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Pdf"  | "Overview,Valuations"             | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Doc"  | "Overview,Valuations"             | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Xlsx" | "Overview,Valuations"             | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Pdf"  | "Overview,Units"                  | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Doc"  | "Overview,Units"                  | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Xlsx" | "Overview,Units"                  | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Pdf"  | "Overview,Loans"                  | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Doc"  | "Overview,Loans"                  | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Xlsx" | "Overview,Loans"                  | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Pdf"  | "Valuations,Loans"                | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Doc"  | "Valuations,Loans"                | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Xlsx" | "Valuations,Loans"                | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Pdf"  | "Valuations,Units"                | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Doc"  | "Valuations,Units"                | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Xlsx" | "Valuations,Units"                | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Pdf"  | "Loans,Units"                     | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Doc"  | "Loans,Units"                     | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Xlsx" | "Loans,Units"                     | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Pdf"  | "Valuations"                      | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Doc"  | "Valuations"                      | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Xlsx" | "Valuations"                      | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Pdf"  | "Loans"                           | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Doc"  | "Loans"                           | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Xlsx" | "Loans"                           | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Pdf"  | "Units"                           | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Doc"  | "Units"                           | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Xlsx" | "Units"                           | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Pdf"  | "Overview"                        | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Doc"  | "Overview"                        | "Successfully Downloaded Asset Details" |
      | "Skyview Apartments" | "Xlsx" | "Overview"                        | "Successfully Downloaded Asset Details" |

