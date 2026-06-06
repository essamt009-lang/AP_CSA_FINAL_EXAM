public class DateConverter {
    private String[] geezMonths = {"መስከረም", "ጥቅምት", "ኅዳር", "ታሕሳስ", "ጥር", "የካቲት", "መጋቢት", "ሚያዝያ", "ግንቦት", "ሰኔ", "ሃምሌ", "ነሐሴ", "ጳጉሜን"}; 
    private String[] copticMonths = {"Tout", "Baba", "Hator", "Kiahk", "Toba", "Amshir", "Baramhat", "Baramouda", "Bashons", "Paona", "Abib", "Mesra", "Nasie"}; 
    private String[] armenianMonths = {"Navasard", "Hori", "Sahmi", "Tre", "Khagots", "Arats", "Mehekan", "Areg", "Ahekan", "Mareri", "Margats", "Hrotits", "Avelyats"}; 

    public String getGregorianMonthName(int gregMonth) { 
        if (gregMonth == 1) {
            return "January";
        } 
        if (gregMonth == 2) {
            return "February"; 
            
        } 
        if (gregMonth == 3) {
            return "March";
        } 
        if (gregMonth == 4) {
            return "April";
        } 
        if (gregMonth == 5) {
            return "May";
        } 
        if (gregMonth == 6) {
            return "June"; 
        } 
        if (gregMonth == 7) { 
            return "July";
        } 
        if (gregMonth == 8) {
            return "August";
        } 
        if (gregMonth == 9) {
            return "September";
        } 
        if (gregMonth == 10) {
            return "October";
        } 
        if (gregMonth == 11) {
            return "November";
        } 
        if (gregMonth == 12) {
            return "December"; 
        } 
        return "Unknown"; 
    }

    public int[] convertGeezToGregorian(int geezMonthIndex, int geezDay){
        int absoluteDays = (geezMonthIndex * 30) + (geezDay - 1);
        int targetMonth = 9;
        int targetDay = 11 + absoluteDays;
        
        if (targetMonth == 9 && targetDay > 30) {
            targetDay = targetDay - 30; targetMonth = 10;
        }
        if (targetMonth == 10 && targetDay > 31) {
            targetDay = targetDay - 31; targetMonth = 11;
            }
        if (targetMonth == 11 && targetDay > 30) {
            targetDay = targetDay - 30; targetMonth = 12; 
        }
        if (targetMonth == 12 && targetDay > 31) { 
            targetDay = targetDay - 31; targetMonth = 1;
            }
        if (targetMonth == 1 && targetDay > 31) {
            targetDay = targetDay - 31; targetMonth = 2;
            }
        if (targetMonth == 2 && targetDay > 28) { 
            targetDay = targetDay - 28; targetMonth = 3; 
        }
        if (targetMonth == 3 && targetDay > 31) { 
            targetDay = targetDay - 31; targetMonth = 4; 
        }
        if (targetMonth == 4 && targetDay > 30) {
            targetDay = targetDay - 30; targetMonth = 5; 
        }
        if (targetMonth == 5 && targetDay > 31) { 
            targetDay = targetDay - 31; targetMonth = 6;
        }
        if (targetMonth == 6 && targetDay > 30) { 
            targetDay = targetDay - 30; targetMonth = 7;
        }
        if (targetMonth == 7 && targetDay > 31) {
            targetDay = targetDay - 31; targetMonth = 8;
        }
        if (targetMonth == 8 && targetDay > 31) {
            targetDay = targetDay - 31; targetMonth = 9; 
        }
        
        int[] result = new int[2];
        result[0] = targetMonth;
        result[1] = targetDay;
        return result;
    }

    public int[] convertGregorianToGeez(int gregMonth, int gregDay) {
        int[] monthlyOffsets = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int dayOfYear = monthlyOffsets[gregMonth] + gregDay;
        int geezAbsoluteDays = dayOfYear - 254;
        
        if (geezAbsoluteDays < 0)
        {
            geezAbsoluteDays = geezAbsoluteDays + 365; 
        }
        
        int targetGeezMonth = geezAbsoluteDays / 30;
        int targetGeezDay = (geezAbsoluteDays % 30) + 1;
        
        int[] result = new int[2];
        result[0] = targetGeezMonth;
        result[1] = targetGeezDay;
        return result;
    }

    public boolean checkValidDate(int ancientMonthIndex, int ancientDay, int gregMonth, int gregDay) {
        if (ancientMonthIndex < 0 || ancientMonthIndex > 12) {
            return false; 
        }
        if (ancientDay < 1) {
            return false; 
        }
        if (ancientMonthIndex < 12 && ancientDay > 30) {
            return false; 
        }
        if (ancientMonthIndex == 12 && ancientDay > 6) {
            return false;
        }
        if (gregMonth < 1 || gregMonth > 12) {
            return false; 
        }
        if (gregDay < 1 || gregDay > 31) {
            return false;
        }
        return true;
    }

    public void printParallelCalendars(int ancientMonthIndex, int ancientDay, int gregMonth, int gregDay) { 
        String gregMonthName = getGregorianMonthName(gregMonth); 

        System.out.println("\n--- Apokty Calender Auto-Conversion ---"); 
        System.out.println("Ge'ez:     " + geezMonths[ancientMonthIndex] + " " + ancientDay); 
        System.out.println("Coptic:    " + copticMonths[ancientMonthIndex] + " " + ancientDay); 
        System.out.println("Armenian:  " + armenianMonths[ancientMonthIndex] + " " + ancientDay); 
        System.out.println("Gregorian: " + gregMonthName + " " + gregDay); 
        System.out.println("---------------------------------------"); 
    } 
}
