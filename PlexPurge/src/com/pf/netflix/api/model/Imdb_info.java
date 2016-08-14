package com.pf.netflix.api.model;

public class Imdb_info
{
    private String Released;

    private String Type;

    private String imdbVotes;

    private String Runtime;

    private String lastUpdated;

    private String FullPlot;

    private String Poster;

    private String imdbID;

    private String Country;

    private String Title;

    private String Year;

    private String imdbRating;

    private String Plot;

    private String Rating;

    private String Writer;

    private String Cast;

    private String Genre;

    private String Language;

    private String Awards;

    private String Director;

    private String Metacritic;

    public String getReleased ()
    {
        return Released;
    }

    public void setReleased (String Released)
    {
        this.Released = Released;
    }

    public String getType ()
    {
        return Type;
    }

    public void setType (String Type)
    {
        this.Type = Type;
    }

    public String getImdbVotes ()
    {
        return imdbVotes;
    }

    public void setImdbVotes (String imdbVotes)
    {
        this.imdbVotes = imdbVotes;
    }

    public String getRuntime ()
    {
        return Runtime;
    }

    public void setRuntime (String Runtime)
    {
        this.Runtime = Runtime;
    }

    public String getLastUpdated ()
    {
        return lastUpdated;
    }

    public void setLastUpdated (String lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    public String getFullPlot ()
    {
        return FullPlot;
    }

    public void setFullPlot (String FullPlot)
    {
        this.FullPlot = FullPlot;
    }

    public String getPoster ()
    {
        return Poster;
    }

    public void setPoster (String Poster)
    {
        this.Poster = Poster;
    }

    public String getImdbID ()
    {
        return imdbID;
    }

    public void setImdbID (String imdbID)
    {
        this.imdbID = imdbID;
    }

    public String getCountry ()
    {
        return Country;
    }

    public void setCountry (String Country)
    {
        this.Country = Country;
    }

    public String getTitle ()
    {
        return Title;
    }

    public void setTitle (String Title)
    {
        this.Title = Title;
    }

    public String getYear ()
    {
        return Year;
    }

    public void setYear (String Year)
    {
        this.Year = Year;
    }

    public String getImdbRating ()
    {
        return imdbRating;
    }

    public void setImdbRating (String imdbRating)
    {
        this.imdbRating = imdbRating;
    }

    public String getPlot ()
    {
        return Plot;
    }

    public void setPlot (String Plot)
    {
        this.Plot = Plot;
    }

    public String getRating ()
    {
        return Rating;
    }

    public void setRating (String Rating)
    {
        this.Rating = Rating;
    }

    public String getWriter ()
    {
        return Writer;
    }

    public void setWriter (String Writer)
    {
        this.Writer = Writer;
    }

    public String getCast ()
    {
        return Cast;
    }

    public void setCast (String Cast)
    {
        this.Cast = Cast;
    }

    public String getGenre ()
    {
        return Genre;
    }

    public void setGenre (String Genre)
    {
        this.Genre = Genre;
    }

    public String getLanguage ()
    {
        return Language;
    }

    public void setLanguage (String Language)
    {
        this.Language = Language;
    }

    public String getAwards ()
    {
        return Awards;
    }

    public void setAwards (String Awards)
    {
        this.Awards = Awards;
    }

    public String getDirector ()
    {
        return Director;
    }

    public void setDirector (String Director)
    {
        this.Director = Director;
    }

    public String getMetacritic ()
    {
        return Metacritic;
    }

    public void setMetacritic (String Metacritic)
    {
        this.Metacritic = Metacritic;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Released = "+Released+", Type = "+Type+", imdbVotes = "+imdbVotes+", Runtime = "+Runtime+", lastUpdated = "+lastUpdated+", FullPlot = "+FullPlot+", Poster = "+Poster+", imdbID = "+imdbID+", Country = "+Country+", Title = "+Title+", Year = "+Year+", imdbRating = "+imdbRating+", Plot = "+Plot+", Rating = "+Rating+", Writer = "+Writer+", Cast = "+Cast+", Genre = "+Genre+", Language = "+Language+", Awards = "+Awards+", Director = "+Director+", Metacritic = "+Metacritic+"]";
    }
}