package db.example;

import db.Entity;
import db.Trackable;

import java.util.Date;

public class Document extends Entity implements Trackable {
    public String content;
    public Date creationDate;
    public Date lastModificationDate;

    public Document (int id, String content) {
        super(id);
        this.content = content;
    }

    public void setCreationDate(Date date) {
        creationDate = date;
    }
    public Date getCreationDate() {
        return creationDate;
    }

    public void setLastModificationDate(Date date) {
        lastModificationDate = date;
    }
    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    @Override
    public Document copy() {
        Document copyDocument = new Document(id,content);
        copyDocument.creationDate = (this.creationDate != null) ? new Date(this.creationDate.getTime()) : null;
        copyDocument.creationDate = (this.lastModificationDate != null) ? new Date(this.lastModificationDate.getTime()) : null;
        return copyDocument;
    }
}
