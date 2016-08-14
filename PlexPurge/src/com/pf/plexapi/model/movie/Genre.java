package com.pf.plexapi.model.movie;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Genre
{
	@XStreamAsAttribute
	private String id;

	@XStreamAsAttribute
	private String count;

	@XStreamAsAttribute
	private String tag;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
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
        return "ClassPojo [id = "+id+", count = "+count+", tag = "+tag+"]";
    }
}