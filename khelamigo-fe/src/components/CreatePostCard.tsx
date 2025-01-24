
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
    <Card sx={{ borderRadius: '20px', marginBottom:'30px' }}>
      <Stack direction="row" spacing={0} sx={{justifyContent: "center", alignItems: "center", margin:'10px'}}>
            <Button>
              <Avatar alt="Remy Sharp" src="/static/images/avatar/1.jpg" />
            </Button>
            <Button
              fullWidth
              disableElevation
              variant="contained"
              sx={{background: '#f0f2f5', borderRadius: '50px', textTransform: 'none', justifyContent: 'flex-start',}}
            >
              <Typography gutterBottom sx={{color: 'text.secondary'}}>
                Set the stage for an epic matchup!
              </Typography>
            </Button>
        </Stack>
      <Divider sx={{ height: 0, m: 0, marginLeft:'20px', marginRight:'20px' }} orientation="horizontal" />
      <CardActions sx={{justifyContent: "center", alignItems: "center"}}>
        <Stack direction="row" spacing={5} sx={{justifyContent: "center", alignItems: "center"}}>
          <Button disableElevation variant="contained" startIcon={<PostAddIcon sx={{color:'#F44336'}} />} sx={{background : 'none', color: 'text.secondary'}}>
            Post
          </Button>
          <Button disableElevation variant="contained" startIcon={<PhotoLibraryIcon sx={{color:'#FF9800'}}/>} sx={{background : 'none', color: 'text.secondary'}}>
            Photo/Video
          </Button>
        </Stack>
        
      </CardActions>
    </Card>
  );
}
