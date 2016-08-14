package com.pf.plexapi.model.library;


import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Directory
{
	@XStreamAsAttribute
    private String art;
	
	@XStreamAsAttribute
    private Location Location;

	@XStreamAsAttribute
    private String type;

	@XStreamAsAttribute
    private String agent;

	@XStreamAsAttribute
    private String allowSync;

	@XStreamAsAttribute
	private String composite;

	@XStreamAsAttribute
	private String updatedAt;

	@XStreamAsAttribute
	private String refreshing;

	@XStreamAsAttribute
	private String title;

	@XStreamAsAttribute
	private String createdAt;

	@XStreamAsAttribute
	private String uuid;

	@XStreamAsAttribute
	private String language;

	@XStreamAsAttribute
	private String thumb;

	@XStreamAsAttribute
	private String scanner;

	@XStreamAsAttribute
	private String key;

	@XStreamAsAttribute
	private String filters;

    public String getArt ()
    {
        return art;
    }

    public void setArt (String art)
    {
        this.art = art;
    }

    public Location getLocation ()
    {
        return Location;
    }

    public void setLocation (Location Location)
    {
        this.Location = Location;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getAgent ()
    {
        return agent;
    }

    public void setAgent (String agent)
    {
        this.agent = agent;
    }

    public String getAllowSync ()
    {
        return allowSync;
    }

    public void setAllowSync (String allowSync)
    {
        this.allowSync = allowSync;
    }

    public String getComposite ()
    {
        return composite;
    }

    public void setComposite (String composite)
    {
        this.composite = composite;
    }

    public String getUpdatedAt ()
    {
        return updatedAt;
    }

    public void setUpdatedAt (String updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public String getRefreshing ()
    {
        return refreshing;
    }

    public void setRefreshing (String refreshing)
    {
        this.refreshing = refreshing;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getCreatedAt ()
    {
        return createdAt;
    }

    public void setCreatedAt (String createdAt)
    {
        this.createdAt = createdAt;
    }

    public String getUuid ()
    {
        return uuid;
    }

    public void setUuid (String uuid)
    {
        this.uuid = uuid;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    public String getThumb ()
    {
        return thumb;
    }

    public void setThumb (String thumb)
    {
        this.thumb = thumb;
    }

    public String getScanner ()
    {
        return scanner;
    }

    public void setScanner (String scanner)
    {
        this.scanner = scanner;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    public String getFilters ()
    {
        return filters;
    }

    public void setFilters (String filters)
    {
        this.filters = filters;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [art = "+art+", Location = "+Location+", type = "+type+", agent = "+agent+", allowSync = "+allowSync+", composite = "+composite+", updatedAt = "+updatedAt+", refreshing = "+refreshing+", title = "+title+", createdAt = "+createdAt+", uuid = "+uuid+", language = "+language+", thumb = "+thumb+", scanner = "+scanner+", key = "+key+", filters = "+filters+"]";
    }
}