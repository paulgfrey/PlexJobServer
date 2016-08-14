package com.pf.plexapi.model.movie;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Role
{
	@XStreamAsAttribute
	private String id;

	@XStreamAsAttribute
	private String tag;

	@XStreamAsAttribute
	private String role;

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

    public String getRole ()
    {
        return role;
    }

    public void setRole (String role)
    {
        this.role = role;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", tag = "+tag+", role = "+role+"]";
    }
}