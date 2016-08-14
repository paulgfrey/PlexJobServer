package com.pf.plexapi.model.library;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Location
{
	@XStreamAsAttribute
	private String id;

	@XStreamAsAttribute
	private String path;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getPath ()
    {
        return path;
    }

    public void setPath (String path)
    {
        this.path = path;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", path = "+path+"]";
    }
}