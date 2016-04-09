package com.example.cb_n898.diabetes.NoteDoctor;

/**
 * Created by cb_n898 on 4/4/2559.
 */
class NotificationNote
{
    public int id;
    public String title;
    public String text;
    public boolean isVisible;

    public NotificationNote(int id, String title, String text, boolean isVisible)
    {
        this.id = id;
        this.title = title;
        this.text = text;
        this.isVisible = isVisible;
    }
}
