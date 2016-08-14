package com.pf.plexapi.model.movie;

import com.pf.plexapi.model.movie.MediaContainer;

public class MovieItem
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