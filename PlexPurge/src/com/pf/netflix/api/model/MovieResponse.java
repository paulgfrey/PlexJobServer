package com.pf.netflix.api.model;

public class MovieResponse
{
    private String responsetime;

    private Netflix_results[] netflix_results;

    private String results;

    private String statuscode;

    public String getResponsetime ()
    {
        return responsetime;
    }

    public void setResponsetime (String responsetime)
    {
        this.responsetime = responsetime;
    }

    public Netflix_results[] getNetflix_results ()
    {
        return netflix_results;
    }

    public void setNetflix_results (Netflix_results[] netflix_results)
    {
        this.netflix_results = netflix_results;
    }

    public String getResults ()
    {
        return results;
    }

    public void setResults (String results)
    {
        this.results = results;
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
        return "ClassPojo [responsetime = "+responsetime+", netflix_results = "+netflix_results+", results = "+results+", statuscode = "+statuscode+"]";
    }
}