/**
 * React Starter Kit (https://www.reactstarterkit.com/)
 *
 * Copyright © 2014-present Kriasoft, LLC. All rights reserved.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */

import React, { PropTypes } from 'react';
import fetch from '../../core/fetch';
import withStyles from 'isomorphic-style-loader/lib/withStyles';
import s from './Home.css';
import data from '../../data/directors.json';

// !!! use your own google api key
const API_KEY = "AIzaSyCFtEf1BMEnt4lsnsyNpJRFxzuU9QmWM-A";

// class Home extends React.Component {
//   static propTypes = {
//     news: PropTypes.arrayOf(PropTypes.shape({
//       title: PropTypes.string.isRequired,
//       link: PropTypes.string.isRequired,
//       content: PropTypes.string,
//     })).isRequired,
//   };

//   render() {
//     return (
//       <div className={s.root}>
//         <div className={s.container}>
//           <h1>React.js News</h1>
//           {this.props.news.map(item => (
//             <article key={item.link} className={s.newsItem}>
//               <h1 className={s.newsTitle}><a href={item.link}>{item.title}</a></h1>
//               <div
//                 className={s.newsDesc}
//                 // eslint-disable-next-line react/no-danger
//                 dangerouslySetInnerHTML={{ __html: item.content }}
//               />
//             </article>
//           ))}
//         </div>
//       </div>
//     );
//   }
// }


class Home extends React.Component {
  async getVideoData(videoId) {
    let url = "https://www.googleapis.com/youtube/v3/videos?id={ videoId }&key={ API_KEY }&part=snippet,contentDetails,statistics,status";

    const resp = await fetch(url, {
      method: 'get',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      }
    });
    
    const { data } = await resp.json();
    return {
      test: <div>data</div>
    }
  }

  getThumbnailUrl(data) {
    return JSON.stringify(data);
    if(typeof data != "object") {
      return null;
    }
    else if(Array.isArray(data)) {
      for(let i = 0; i < data.length; i++) {
        this.getThumbnailUrl(data[i]);
      }
    }
    else {
      for(let key in data) {
        if(key == "high") {
          return data[key].url;
        }
        else {
          this.getThumbnailUrl(data[key]);
        }
      }
    }
  }

  render() {
    return (
      <div class="directors">
      {
        data.directors.map(director => (
          <div class="director">
            <div>{ director.name }</div>
            <div class="movies">
              {
                director.movies.map(movie => (
                  <div class="movie">
                    <div class="title">
                    { movie.title }
                    </div>

                    <div class="year">
                    { movie.year }
                    </div>

                    <div class="video">
                    { <iframe width="560" height="315" src={"https://www.youtube.com/embed/" + movie.link } frameborder="0"></iframe> }
                    </div>
                  </div>
                ))
              }
            </div>
          </div>
        ))
      }
      </div>
    );
  }
}
export default withStyles(s)(Home);

