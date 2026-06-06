public class Holiday 
{
    private String name;
    private int gregMonth; 
    private int gregDay;   

    public Holiday(String newName, int newMonth, int newDay) 
    {
        name = newName;
        gregMonth = newMonth;
        gregDay = newDay;
    }

    public String getName() 
    { 
        return name; 
    }
    
    public void setName(String newName) 
    { 
        name = newName; 
    }
    
    public int getGregMonth() 
    { 
        return gregMonth; 
    }
    
    public void setGregMonth(int newMonth) 
    { 
        gregMonth = newMonth; 
    }
    
    public int getGregDay() 
    { 
        return gregDay; 
    }
    
    public void setGregDay(int newDay) 
    { 
        gregDay = newDay; 
    }

    public String toString() 
    { 
        return name + " (" + gregMonth + "/" + gregDay + ")"; 
    }
}
