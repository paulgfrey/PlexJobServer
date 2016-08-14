package com.pf.plexapi.model.movie;

public class Collection
{
    private String id;

    private String tag;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTag ()
    {
        return tag;
    }

    public void setTag (String tag)
    {
        this.tag = tag;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", tag = "+tag+"]";
    }
}