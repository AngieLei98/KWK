var quoteOptions = [{
  quote:"“If you judge people, you have no time to love them.”",
  name:  "Mother Theresa"
}, {
  quote: "“It is the friends you can call up at 4 A.M. that matter.”",
  name: "Marlene Dietrich"
}, {
  quote: "“A gossip is someone who talks to you about others, a bore is someone who talks to you about himself, and a brilliant conversationalist is one who talks to you about yourself. ”",
  name: "Lisa Kirk"
}, {
  quote: "“I have yet to hear a man ask for advice on how to combine marrige and a career. ”",
  name: "Gloria Steinem"
}, {
  quote: "“In politics, if you want anything said, ask a man- if you want anything done, ask a woman.”",
  name: " Margaret Thatcher"
}, {
  quote: "“Take your work seriously, but never yourself.”",
  name: "Dame Margot Fonteyn"
}, {
  quote: "“I'm selfish, impatient and a little insecure. I make mistakes, I am out of control and at times hard to handle. But if you can't handle me at my worst, then you sure as hell don't deserve me at my best.”" ,
  name: "Marilyn Monroe"
}, {
  quote: "“Whoever said money can't buy happiness didn't know where to shop.”",
  name: "Gertrude Stein"
}, {
  quote: "“Vodka is kind of a hobby.”",
  name: "Betty White"
}, {
  quote: "“I haven't trusted polls since I read that 62% of women had affairs during their lunch hour. I've never met a woman in my life who would give up lunch for sex.”",
  name: "Erma Bombeck"
},
{
  quote: "“There is no pleasure in having nothing to do; the fun is in having lots to do and not doing it. ”",
  name: "Mary Wilson Little"
},
{
  quote: "“Nobody can make you feel inferior without your permission.”",
  name: "Eleanor Roosevelt"
},
{
  quote: "“When there is no enemy within, the enemies outside cannot hurt you.",
  name: "African proverb"
},
{
  quote: "“Fashion can be bought. Style one must possess.”",
  name: "Edna Woolman Chase"
} ,
{
  quote: "“Exercise is a dirty word. Every time I hear it, I wash my mouth out with chocolate.”",
  name: "Anon"
},
{
  quote: "“If you want the rainbow, you've got to put up with the rain.”",
  name: "Dolly Parton"
},
{
  quote: "“It's never too late to be what you might have been.”",
  name: "George Eliot"
}
];

function generate() {
  var randomQuote = Math.floor((Math.random() * quoteOptions.length));
  for (var i = 0; i <= quoteOptions.length; i++) {

    if (i === randomQuote) {
    //call the generate html helper function
      var quoteForHtml = createHtml(quoteOptions[i]);
      $('.quote').empty().append(quoteForHtml); //jQuery add it onto the .quote class in html
  }
}
}

//html helper function
function createHtml(quote) {

  var quoteForHtml = "<i> " + quote["quote"] + " </i> <br> <b> - " + quote["name"] + " </b>";
  return quoteForHtml;
}
