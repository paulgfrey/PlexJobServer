package com.pf.plexapi.model.movies;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Genre
{
	@XStreamAsAttribute
	private String tag;

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
        return "ClassPojo [tag = "+tag+"]";
    }
}