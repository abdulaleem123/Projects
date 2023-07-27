import tkinter as tk
import nltk
from textblob import TextBlob
from newspaper import Article

def summarize():
    url=utext.get('1.0','end').strip()
    article=Article(url)
    article.download()
    article.parse()
    article.nlp()

    #print(f'title: {article.title} ')

    #we have to perform below thing and change it to normal otherwise there's no chnace to mkae our text box in our GUI work
    title.config(state='normal')
    author.config(state='normal')
    publication.config(state='normal')
    summary.config(state='normal')
    sentiment.config(state='normal')
    # changing the context of the indivitual text boxes
    title.delete('1.0','end')
    title.insert('1.0',article.title)

    author.delete('1.0', 'end')
    author.insert('1.0', article.authors)

    if article.publish_date is not None:
        publication.delete('1.0', 'end')
        publication.insert('1.0', article.publish_date.strftime('%Y-%m-%d %H:%M:%S'))
    else:
        publication.delete('1.0', 'end')
        publication.insert('1.0', 'Not available')

    summary.delete('1.0', 'end')
    summary.insert('1.0', article.summary)

    analysis = TextBlob(article.text)  # performing sentiments analysis
    #print(analysis.polarity)  # sentiment checking
    sentiment.delete('1.0','end')
    sentiment.insert('1.0',f'polarity:{analysis.polarity},{"Positive" if analysis.polarity > 0 else "Negative" if analysis.polarity < 0 else "Neutral"}')
    #print(f'sentiment:{"Positive" if analysis.polarity > 0 else "Negative" if analysis.polarity < 0 else "Neutral"}')

    #disabling them after our work is done
    title.config(state='disabled')
    author.config(state='disabled')
    publication.config(state='disabled')
    summary.config(state='disabled')
    sentiment.config(state='disabled')


root=tk.Tk()
root.title("News Summarizer")
root.geometry('1200x600')
tlabel=tk.Label(root,text="Title")
tlabel.pack()
title=tk.Text(root,height=1,width=140)
title.config(state='disabled',bg='#dddddd')
title.pack()

alabel=tk.Label(root,text="Author")
alabel.pack()
author=tk.Text(root,height=1,width=140)
author.config(state='disabled',bg='#dddddd')
author.pack()

plabel=tk.Label(root,text="Publication date")
plabel.pack()
publication=tk.Text(root,height=1,width=140)
publication.config(state='disabled',bg='#dddddd')
publication.pack()

slabel=tk.Label(root,text="Summary")
slabel.pack()
summary=tk.Text(root,height=20,width=140)
summary.config(state='disabled',bg='#dddddd')
summary.pack()

selabel=tk.Label(root,text="Sentiment Analysis")
selabel.pack()
sentiment=tk.Text(root,height=1,width=140)
sentiment.config(state='disabled',bg='#dddddd') #disabled so the user can't access it
sentiment.pack()

ulabel=tk.Label(root,text="URL")
ulabel.pack()
#we didnt config cuz we want the user to use this thing
utext=tk.Text(root,height=1,width=140)
utext.pack()

btn=tk.Button(root,text="Summarize",command=summarize)
btn.pack()
root.mainloop()
