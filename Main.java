// YOUR NAME: Joe Carita
// COLLABORATORS: Joe Carita
// DATE: 10/3/2024

public class Main
{
//ascii art credit: http://www.oocities.org/spunk1111/bodypart.htm
        public static final String ASCII_ART_0 = "    .----.    .----.  ",
            ASCII_ART_1 = "   (  --  \\  /  --  )",
            ASCII_ART_2 = "          |  |        ",
            ASCII_ART_3 = "         _/  \\_      ",
            ASCII_ART_4 = "        (_    _)      ",
            ASCII_ART_5 = "     ,    `--`    ,   ",
            ASCII_ART_6 = "     \\'-.______.-'/  ",
            ASCII_ART_7 = "      \\          /   ",
            ASCII_ART_8 = "       '.--..--.'     ",
            ASCII_ART_9 = "         `\"\"\"\"\"` ",
            ASCII_CREDIT = "   ascii art by: jgs    ";

    public static final String TITLE_USA = "UNITED STATES OF AMERICA",
            TITLE_EAC = "EMPLOYMENT AUTHORIZATION CARD";
    public static final String LABEL_SURNAME = "Surname", LABEL_GIVEN_NAME = "Given Name", LABEL_USCIS_NUM = "USCIS#",
            LABEL_CATEGORY = "Category", LABEL_CARD_NUM = "Card#", LABEL_BIRTH_COUNTRY = "Country of Birth",
            LABEL_TERMS_CONDITIONS = "Terms and Conditions", LABEL_BIRTH_DATE = "Date of Birth",
            LABEL_SEX = "Sex", LABEL_VALID_DATE = "Valid From:", LABEL_EXPIRE_DATE = "Card Expires:",
            LABEL_REENTRY_DISCLAIMER = "NOT VALID FOR REENTRY TO U.S.";

    public static void main(String[] args)
    {
        
        //DECLARATION SECTION
        //complete fields
        String surname, givenName, category, cardNum, birthCountry, termsAndConditions;
        char sex;

        //parts of fields
        String birthMonth;
        int uscisNum1, uscisNum2, uscisNum3, birthDay, birthYear,
                validDay, validMonth, validYear, expireMonth, expireDay, expireYear;

        //extra vars to help with formatting of Strings (not raw data like above vars)
        String uscisNum, dateOfBirth, validDate, expireDate;

        //INITIALIZATION SECTION
        surname = UtilityBelt.readString("What is your first name? ",1,25);
        givenName = UtilityBelt.readString("What is your last name? ",1,25);
        uscisNum1 = UtilityBelt.readInt("What is the first part of your USCIS number? ",1,999);
        uscisNum2 = UtilityBelt.readInt("What is the second part of your USCIS number? ",1,999);
        uscisNum3 = UtilityBelt.readInt("What is the last part of your USCIS number? ",1,999);
        category = UtilityBelt.readString("What category are you in? ",3,3);
        cardNum = UtilityBelt.readString("What is your card number? ",13,13);
        birthCountry = UtilityBelt.readString("What is your country of birth? ",3,25);
        termsAndConditions = "None";

        birthDay = UtilityBelt.readInt("What day were you born on? ",1,31);
        birthMonth = UtilityBelt.readString("What are the first 3 characters of your birth month? ",3,3);
        birthYear = UtilityBelt.readInt("What was your birth year? ",1900,3000);

        sex = UtilityBelt.readChar("What is your sex? First character only. ","FM"); //note single quotes

        validMonth = UtilityBelt.readInt("What month is this card valid from? ",1,12);
        validDay = UtilityBelt.readInt("What day is this card valid from? ",1,31);
        validYear = UtilityBelt.readInt("What year is this card valid from? ",1900,3000);

        expireMonth = UtilityBelt.readInt("What month is this card valid until? ",1,12);
        expireDay = UtilityBelt.readInt("What day is this card valid until? ",1,31);
        expireYear = UtilityBelt.readInt("What year is this card valid until? ",1900,3000);

        //Strings to help clean up long printf's below
        uscisNum = String.format("%03d-%03d-%03d", uscisNum1, uscisNum2, uscisNum3);
        dateOfBirth = String.format("%02d %s %d", birthDay, birthMonth, birthYear);
        validDate = Main.formatDate(validMonth,validDay,validYear);
        expireDate = Main.formatDate(expireMonth, expireDay, expireYear);


        //INPUT + CALCULATION SECTION
        //N/A

        //OUTPUT SECTION
        System.out.println(Main.formatCard(surname, givenName, category, cardNum, birthCountry, termsAndConditions, sex, uscisNum, dateOfBirth, validDate, expireDate));
    }
    public static String formatCard(String surname, String givenName,
        String category, String cardNum, String birthCountry, 
        String termsAndConditions, char sex, String uscisNum, 
        String dateOfBirth, String validDate, String expireDate)
        {
                String fullCard = "";
                fullCard+=
                        String.format("╔══════════════════════════════════════════════════════════════════════╗%n") +
                        String.format("║%35s%35s║%n", TITLE_USA, "") +
                        String.format("║%60s%10s║%n", TITLE_EAC, "") +
                        String.format("║%-25s%-45s║%n", "", LABEL_SURNAME) +
                        String.format("║%-25s%-45s║%n", "", surname) +
                        String.format("║%-25s%-45s║%n", ASCII_ART_0, LABEL_GIVEN_NAME) +
                        String.format("║%-25s%-45s║%n", ASCII_ART_1, givenName) +
                        String.format("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_2, LABEL_USCIS_NUM, LABEL_CATEGORY, LABEL_CARD_NUM) +
                        String.format("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_3, uscisNum, category, cardNum) +
                        String.format("║%-25s%-45s║%n", ASCII_ART_4, LABEL_BIRTH_COUNTRY) +
                        String.format("║%-25s%-45s║%n", ASCII_ART_5, birthCountry) +
                        String.format("║%-25s%-45s║%n", ASCII_ART_6, LABEL_TERMS_CONDITIONS) +
                        String.format("║%-25s%-45s║%n", ASCII_ART_7, termsAndConditions) +
                        String.format("║%-25s%-15s%-30s║%n", ASCII_ART_8, LABEL_BIRTH_DATE, LABEL_SEX) +
                        String.format("║%-25s%-15s%-30s║%n", ASCII_ART_9, dateOfBirth, sex) +
                        String.format("║%-25s%-15s%-30s║%n", "", LABEL_VALID_DATE, validDate) +
                        String.format("║%-25s%-15s%-30s║%n", "", LABEL_EXPIRE_DATE, expireDate) +
                        String.format("║%-25s%-45s║%n", ASCII_CREDIT, LABEL_REENTRY_DISCLAIMER) +
                        String.format("╚══════════════════════════════════════════════════════════════════════╝");
                return(fullCard);
        }       
        public static String formatDate(int month, int day, int year)
        {
                String formattedDate;
                formattedDate = String.format("%02d/%02d/%04d",month,day,year);
                return(formattedDate);
        }
}