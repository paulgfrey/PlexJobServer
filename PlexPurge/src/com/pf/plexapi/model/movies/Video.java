package com.pf.plexapi.model.movies;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

import com.pf.plexapi.model.movies.Collection;

public class Video
{
	@XStreamAsAttribute
	private String studio;

	@XStreamAsAttribute
	private String summary;

	@XStreamAsAttribute
	private String primaryExtraKey;

	@XStreamAsAttribute
	private String ratingKey;

	@XStreamAsAttribute
	private String audienceRatingImage;

	@XStreamAsAttribute
	private String type;

	@XStreamAsAttribute
	private String title;

	@XStreamImplicit
	private Genre[] Genre;

	@XStreamAsAttribute
	private String year;

	@XStreamImplicit
	private Director[] Director;

	@XStreamAsAttribute
	private String key;

	@XStreamAsAttribute
	private String originallyAvailableAt;

	@XStreamImplicit(itemFieldName="Media")
    private List<Media> Media;

	@XStreamAsAttribute
	private String chapterSource;

	@XStreamAsAttribute
	private String art;

	@XStreamAsAttribute
	private String ratingImage;

	@XStreamImplicit
	private Country[] Country;

	@XStreamAsAttribute
	private String updatedAt;

	@XStreamAsAttribute
	private String duration;

    @XStreamImplicit
    private Writer[] Writer;

	@XStreamAsAttribute
	private String contentRating;

	@XStreamAsAttribute
	private String addedAt;

	@XStreamImplicit
	private Role[] Role;

	@XStreamAsAttribute
	private String rating;

	@XStreamAsAttribute
	private String thumb;

	@XStreamAsAttribute
	private String tagline;
	
	private Collection Collection;

    public String getStudio ()
    {
        return studio;
    }

    public void setStudio (String studio)
    {
        this.studio = studio;
    }

    public String getSummary ()
    {
        return summary;
    }

    public void setSummary (String summary)
    {
        this.summary = summary;
    }

    public String getPrimaryExtraKey ()
    {
        return primaryExtraKey;
    }

    public void setPrimaryExtraKey (String primaryExtraKey)
    {
        this.primaryExtraKey = primaryExtraKey;
    }

    public String getRatingKey ()
    {
        return ratingKey;
    }

    public void setRatingKey (String ratingKey)
    {
        this.ratingKey = ratingKey;
    }

    public String getAudienceRatingImage ()
    {
        return audienceRatingImage;
    }

    public void setAudienceRatingImage (String audienceRatingImage)
    {
        this.audienceRatingImage = audienceRatingImage;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public Genre[] getGenre ()
    {
        return Genre;
    }

    public void setGenre (Genre[] Genre)
    {
        this.Genre = Genre;
    }

    public String getYear ()
    {
        return year;
    }

    public void setYear (String year)
    {
        this.year = year;
    }

    public Director[] getDirector ()
    {
        return Director;
    }

    public void setDirector (Director[] Director)
    {
        this.Director = Director;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    public String getOriginallyAvailableAt ()
    {
        return originallyAvailableAt;
    }

    public void setOriginallyAvailableAt (String originallyAvailableAt)
    {
        this.originallyAvailableAt = originallyAvailableAt;
    }

    public List<Media> getMedia ()
    {
        return Media;
    }

    public void setMedia (List<Media> Media)
    {
        this.Media = Media;
    }

    public String getChapterSource ()
    {
        return chapterSource;
    }

    public void setChapterSource (String chapterSource)
    {
        this.chapterSource = chapterSource;
    }

    public String getArt ()
    {
        return art;
    }

    public void setArt (String art)
    {
        this.art = art;
    }

    public String getRatingImage ()
    {
        return ratingImage;
    }

    public void setRatingImage (String ratingImage)
    {
        this.ratingImage = ratingImage;
    }

    public Country[] getCountry ()
    {
        return Country;
    }

    public void setCountry (Country[] Country)
    {
        this.Country = Country;
    }

    public String getUpdatedAt ()
    {
        return updatedAt;
    }

    public void setUpdatedAt (String updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public Writer[] getWriter ()
    {
        return Writer;
    }

    public void setWriter (Writer[] Writer)
    {
        this.Writer = Writer;
    }

    public String getContentRating ()
    {
        return contentRating;
    }

    public void setContentRating (String contentRating)
    {
        this.contentRating = contentRating;
    }

    public String getAddedAt ()
    {
        return addedAt;
    }

    public void setAddedAt (String addedAt)
    {
        this.addedAt = addedAt;
    }

    public Role[] getRole ()
    {
        return Role;
    }

    public void setRole (Role[] Role)
    {
        this.Role = Role;
    }

    public String getRating ()
    {
        return rating;
    }

    public void setRating (String rating)
    {
        this.rating = rating;
    }

    public String getThumb ()
    {
        return thumb;
    }

    public void setThumb (String thumb)
    {
        this.thumb = thumb;
    }

    public String getTagline ()
    {
        return tagline;
    }

    public void setTagline (String tagline)
    {
        this.tagline = tagline;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [studio = "+studio+", summary = "+summary+", primaryExtraKey = "+primaryExtraKey+", ratingKey = "+ratingKey+", audienceRatingImage = "+audienceRatingImage+", type = "+type+", title = "+title+", Genre = "+Genre+", year = "+year+", Director = "+Director+", key = "+key+", originallyAvailableAt = "+originallyAvailableAt+", Media = "+Media+", chapterSource = "+chapterSource+", art = "+art+", ratingImage = "+ratingImage+", Country = "+Country+", updatedAt = "+updatedAt+", duration = "+duration+", Writer = "+Writer+", contentRating = "+contentRating+", addedAt = "+addedAt+", Role = "+Role+", rating = "+rating+", thumb = "+thumb+", tagline = "+tagline+"]";
    }

	public Collection getCollection() {
		return Collection;
	}

	public void setCollection(Collection collection) {
		this.Collection = collection;
	}
}