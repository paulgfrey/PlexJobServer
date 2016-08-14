package com.pf.plexapi.model.movies;

public class Movies
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