package com.pf.netflix.api.model;

public class Netflix_results
{
    private String id;

    private Imdb_info[] imdb_info;

    private String category;

    private String title;

    private String cast;

    private String poster;

    private String year;

    private String available;

    private String rating;

    private String netflix_id;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Imdb_info[] getImdb_info ()
    {
        return imdb_info;
    }

    public void setImdb_info (Imdb_info[] imdb_info)
    {
        this.imdb_info = imdb_info;
    }

    public String getCategory ()
    {
        return category;
    }

    public void setCategory (String category)
    {
        this.category = category;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getCast ()
    {
        return cast;
    }

    public void setCast (String cast)
    {
        this.cast = cast;
    }

    public String getPoster ()
    {
        return poster;
    }

    public void setPoster (String poster)
    {
        this.poster = poster;
    }

    public String getYear ()
    {
        return year;
    }

    public void setYear (String year)
    {
        this.year = year;
    }

    public String getAvailable ()
    {
        return available;
    }

    public void setAvailable (String available)
    {
        this.available = available;
    }

    public String getRating ()
    {
        return rating;
    }

    public void setRating (String rating)
    {
        this.rating = rating;
    }

    public String getNetflix_id ()
    {
        return netflix_id;
    }

    public void setNetflix_id (String netflix_id)
    {
        this.netflix_id = netflix_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", imdb_info = "+imdb_info+", category = "+category+", title = "+title+", cast = "+cast+", poster = "+poster+", year = "+year+", available = "+available+", rating = "+rating+", netflix_id = "+netflix_id+"]";
    }
}