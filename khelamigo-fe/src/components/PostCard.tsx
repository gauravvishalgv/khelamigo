import * as React from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import CommentIcon from '@mui/icons-material/Comment';
import ShareIcon from '@mui/icons-material/Share';
import Typography from '@mui/material/Typography';
import Stack from '@mui/material/Stack';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';

export default function PostCard() {
  return (
    <Card sx={{ minWidth: '100%', borderRadius:'20px' }}>
        <Stack
            direction="row"
            spacing={1.5}
            sx={{padding: '10px'}}
            alignItems= 'center'
        >
            <Avatar alt="Remy Sharp" src="/static/images/avatar/1.jpg" />
            <Stack
                direction="column"
                spacing={-0.2}
                sx={{}}
                alignItems= 'left'
            >
                <Typography gutterBottom component="div" sx={{ fontWeight: 'bold', color: 'text.primary', fontSize:14 }}>Gaurav Vishal</Typography>
                <Typography gutterBottom component="div" sx={{ fontWeight: 'bold', color: 'text.secondary', fontSize:12 }}>November 19 at 12:56PM</Typography>
            </Stack>
            
        </Stack>
      <CardMedia
        sx={{ height: 300 }}
        image="https://img.freepik.com/free-photo/sports-tools_53876-138077.jpg"
        title="green iguana"
      />
      <CardContent>
        <Typography variant="body2" sx={{ color: 'text.secondary' }}>
        Sports teach us teamwork, discipline, and perseverance. Whether you play or watch, they inspire us to push limits and embrace challenges.
        </Typography>
      </CardContent>
      <CardActions>
        <IconButton aria-label="like">
            <FavoriteBorderIcon/>
        </IconButton>
        <IconButton aria-label="comment">
            <CommentIcon/>
        </IconButton>
        <IconButton aria-label="share">
            <ShareIcon/>
        </IconButton>
      </CardActions>
    </Card>
  );
}