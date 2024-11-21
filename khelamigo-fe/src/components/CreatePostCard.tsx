
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import Avatar from '@mui/material/Avatar';
import Divider from '@mui/material/Divider';
import Typography from '@mui/material/Typography';

import PostAddIcon from '@mui/icons-material/PostAdd';
import PhotoLibraryIcon from '@mui/icons-material/PhotoLibrary';


export default function CreatePostCard() {
  return (
    <Card sx={{ borderRadius: '20px'}}>
       
      <CardContent>
        <Stack direction="row" spacing={2} sx={{justifyContent: "center", alignItems: "center"}}>
            <Avatar alt="Remy Sharp" src="/static/images/avatar/1.jpg" />
            <Button
              fullWidth
              disableElevation
              variant="contained"
              sx={{background: '#f0f2f5', borderRadius: '50px', textTransform: 'none', justifyContent: 'flex-start',}}
            >
              <Typography variant="h6" gutterBottom sx={{color:'gray'}}>
                Set the stage for an epic matchup!
              </Typography>
            </Button>
        </Stack>
        <Divider sx={{ height: 0, m: 0 }} orientation="horizontal" />
      </CardContent>
      <CardActions sx={{justifyContent: "center", alignItems: "center"}}>
        <Stack direction="row" spacing={2} sx={{justifyContent: "center", alignItems: "center"}}>
          <Button disableElevation variant="contained" startIcon={<PostAddIcon sx={{color:'#F44336'}} />} sx={{background : 'none', color: 'gray'}}>
            Post
          </Button>
          <Button disableElevation variant="contained" startIcon={<PhotoLibraryIcon sx={{color:'#FF9800'}}/>} sx={{background : 'none', color: 'gray'}}>
            Photo/Video
          </Button>
        </Stack>
        
      </CardActions>
    </Card>
  );
}
