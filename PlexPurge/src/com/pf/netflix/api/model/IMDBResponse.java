
package com.pf.netflix.api.model;


public class IMDBResponse
{
    private String responsetime;

    private String results;

    private String netflix_id;

    private String statuscode;

    public String getResponsetime ()
    {
        return responsetime;
    }

    public void setResponsetime (String responsetime)
    {
        this.responsetime = responsetime;
    }

    public String getResults ()
    {
        return results;
    }

    public void setResults (String results)
    {
        this.results = results;
    }

    public String getNetflix_id ()
    {
        return netflix_id;
    }

    public void setNetflix_id (String netflix_id)
    {
        this.netflix_id = netflix_id;
    }

    public String getStatuscode ()
    {
        return statuscode;
    }

    public void setStatuscode (String statuscode)
    {
        this.statuscode = statuscode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [responsetime = "+responsetime+", results = "+results+", netflix_id = "+netflix_id+", statuscode = "+statuscode+"]";
    }
}