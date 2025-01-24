import * as React from 'react';
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Stack from '@mui/material/Stack';
import { styled } from '@mui/material/styles';
import PostCard from './PostCard';

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
  ...theme.applyStyles('dark', {
    backgroundColor: '#1A2027',
  }),
}));

export default function PostScroll() {
  return (
    <Box sx={{ width: '100%' }}>
      <Stack spacing={4}>
        {Array.from({ length: 20 }).map((_, index) => (
          <PostCard key={index} />
        ))}
      </Stack>
    </Box>
  );
}