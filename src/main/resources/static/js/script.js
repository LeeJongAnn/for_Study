const toggle = document.getElementById("toggle");
const mute = document.getElementById("mute");
const locations = document.getElementById("locations");
const speed = document.getElementById("speed");
const audio = document.getElementById("music");
const play = document.getElementById("play");
const prev = document.getElementById("prev");
const next = document.getElementById("next");
const loading = document.getElementById("loading");
const data=[{
            city:'Seoul',
            videos:[
                'o7yBB2KlID8'
                ],
            music:[
                'http://209.58.145.135:8025/stream?listening-from-radio-garden=1657367108',
                'http://107.150.53.50:4001/s?listening-from-radio-garden=1657367278',
            ]
        },
        {
            city:'Tokyo',
            videos:[
                '0zRLLqpvS3Q',
                'PKTbmeL73sE',
                'BjZIQa2rS9I'
                ],
            music:[
                'http://209.58.145.135:8025/stream',
                'http://209.58.145.135:8001/stream'
            ]
        },
           {
                      city:'jeju',
                      videos:[
                          'X6OqYQZkhys',
                          'lXKvoku6gPg'
                          ],
                      music:[
                          'http://209.58.145.135:8025/stream',
                          'http://209.58.145.135:8001/stream'
                      ]
                  }
 ];

var CityIndex;
var City;
var VideoIndex;
var Video;
var AudioIndex;
var Audio;
const UseSpeeds = [0.5,1,1.5,2]
load()
function load(){
    CityIndex = randomNumber(data.length);
    City = data[CityIndex];
    VideoIndex = randomNumber(City.videos.length);
    Video = City.videos[VideoIndex];
    AudioIndex = randomNumber(City.music.length);
    Audio = City.music[AudioIndex];

    audio.src = Audio;
    audio.volume = 0.5;
    play.classList.remove('fa-play');
    play.classList.add('fa-pause');

    data.forEach((el,idx) => {
        var LiElement = document.createElement('li');
        LiElement.innerText = el.city;
        LiElement.id = idx;
        LiElement.addEventListener('click', (e) =>{
            CityIndex = Number(e.target.id);
            City = data[CityIndex];

            VideoIndex = randomNumber(City.videos.length);
            Video = City.videos[VideoIndex];
            AudioIndex = randomNumber(City.music.length);
            Audio = City.music[AudioIndex];
            audio.src = Audio;
            audio.volume = 0.5;
            play.classList.remove('fa-play');
            play.classList.add('fa-pause');
        });

    })

    UseSpeeds.forEach((el,idx) => {
    var speedEl = document.createElement('p');
    speedEl.id = el;
    speedEl.innerText = el + 'x';
    speedEl.addEventListener('click', (e) =>{
        player.setPlaybackRate(Number(e.target.id))
    })
    speed.append(speedEl);

    })
}


function randomNumber(max){
    return Math.floor(Math.random() * (max))
}


play.addEventListener('click',()=>{
    if(audio.paused){
        audio.play()
        play.classList.remove('fa-play');
        play.classList.add('fa-pause');
    }else {
        audio.pause()
        play.classList.remove('fa-pause');
        play.classList.add('fa-play');
    }
})

next.addEventListener('click', ()=>{
    if(VideoIndex < (City.music.length - 1)){
        AudioIndex++
    }else {
        AudioIndex = 0
    }

    Audio = City.music[AudioIndex];
    audio.src = Audio;
    audio.play()
})
mute.addEventListener('click',()=>{
    if(player.isMuted()){
        player.unMute();
        mute.innerText = 'On'
    } else {
        player.mute();
        mute.innerText = 'Off'
    }
})

toggle.addEventListener('click',()=>{
    document.querySelector('.sidebar').classList.toggle('hide');
})

prev.addEventListener('click', ()=>{
    if(AudioIndex>0){
    AudioIndex--
    }
        else{
        AudioIndex = City.music.length-1;
    }
     Audio = City.music[AudioIndex];
     audio.src = Audio;
     audio.play()
})


      var tag = document.createElement('script');

      tag.src = "https://www.youtube.com/iframe_api";
      var firstScriptTag = document.getElementsByTagName('script')[0];
      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

      var player;
      function onYouTubeIframeAPIReady() {
        player = new YT.Player('player', {
          height: window.innerHeight * 1.2,
          width: window.innerHeight * 1.2 *(16/9),
          videoId: Video,
          playerVars: {
            'playsinline': 1,
            'controls': 0,
            'mute':1,
            'showinfo':0,
            'enablejsapi':1,
            'disablekb':1,
            'modestbranding':1,
            'origin':window.location.origin,
            'widget_referrer':window.location.href
          },
          events: {
            'onReady': onPlayerReady,
            'onStateChange': onPlayerStateChange
          }
        });
      }

      function onPlayerReady(event) {
        event.target.playVideo();
      }

      function onPlayerStateChange(event) {
        if(event.data == YT.PlayerState.ENDED){
            if(VideoIndex < City.videos.length) {
                VideoIndex++
            } else {
                VideoIndex = 0
            }

            Video = City.videos[VideoIndex];
            player.loadVideoById({videoId: Video});
        }

        if(event.data == YT.PlayerState.BUFFERING){
            loading.style.display = 'flex';
        }
        if (event.data == YT.PlayerState.PLAYING) {
           loading.style.display='flex';
           setTimeout(()=> {
            loading.style.display = 'none'
           },3000);
        }
      }
      function changeVolume(e){
        audio.volume = parseFloat(e.value / 100);
      }

      function stopVideo() {
        player.stopVideo();
      }