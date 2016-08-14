package com.pf.plexapi.model.library;

public class Libraries
{
    private MediaContainer MediaContainer;

    public MediaContainer getMediaContainer ()
    {
        return MediaContainer;
    }

    public void setMediaContainer (MediaContainer MediaContainer)
    {
        this.MediaContainer = MediaContainer;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [MediaContainer = "+MediaContainer+"]";
    }
}